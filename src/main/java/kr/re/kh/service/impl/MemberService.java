package kr.re.kh.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.re.kh.mapper.MemberMapper;
import kr.re.kh.payload.request.ChangePwRequest;
import kr.re.kh.payload.request.JoinRequest;
import kr.re.kh.service.CrudService;
import kr.re.kh.util.StringUtil;
import kr.re.kh.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements CrudService<MemberVO> {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<MemberVO> selectList(MemberVO e) {
        return mapper.selectList(e);
    }
    @Override
    public MemberVO selectOne(MemberVO e) {
        return mapper.selectOne(e);
    }

    /**
     * 입력받은 아이디와 비밀번호를 이용해 계정을 찾고 로그인
     * @param userID
     * @param password
     * @return
     */
    public MemberVO selectOne(String userID, String password) {
        MemberVO vo = new MemberVO();
        vo.setUserID(userID);
        vo.setPassword(password);
        return mapper.selectOne(vo);
    }

    @Override
    public void insert(MemberVO e) {
        mapper.insert(e);
    }
    @Override
    public void update(MemberVO e) {

    }
    @Override
    public void delete(MemberVO e) {

    }

    /**
     * 회원가입을 위한 아이디 중복여부 확인
     * @param userID
     * @return
     */
    public HashMap<String, Object> checkUserID(String userID) {
        int cnt = mapper.checkUserID(userID);
        HashMap<String, Object> map = new HashMap<>();
        map.put("isExist", cnt == 0? false: true);
        return map;
    }

    /**
     * 회원가입을 위한 이메일 중복여부 확인
     * @param email
     * @return
     */
    public HashMap<String, Object> checkEmail(String email) {
        int cnt = mapper.checkEmail(email);
        HashMap<String, Object> map = new HashMap<>();
        map.put("isExist", cnt == 0? false: true);
        return map;
    }

    /**
     * 회원가입 처리
     * @param joinRequest
     * @return
     */
    public HashMap<String, Object> memberJoin(JoinRequest joinRequest) {
        HashMap<String, Object> map = new HashMap<>();

        // 아이디 중복 체크
        HashMap<String, Object> idMap = this.checkUserID(joinRequest.getUserID());
        boolean idExist = (boolean)idMap.get("isExist");

        if (idExist) {
            map.put("result", false);
            return map;
        }
        // 이메일 중복 체크
        HashMap<String, Object> emailMap = this.checkEmail(joinRequest.getEmail());
        boolean emailExist = (boolean)emailMap.get("isExist");

        if (emailExist) {
            map.put("result", false);
            return map;
        }

        MemberVO memberVO = MemberVO.builder()
                .email(joinRequest.getEmail())
                .userID(joinRequest.getUserID())
                .password(joinRequest.getPassword())
                .username(joinRequest.getUsername())
                .build();

        this.insert(memberVO);

        map.put("result", true);
        map.put("message", "회원가입 완료");
        log.info(String.valueOf(map));

        return map;
    }

    /**
     * 이메일 입력받아 아이디 찾기
     * @param email
     * @return
     */
    public HashMap<String, Object> findID(String email) {
        HashMap<String, Object> map = new HashMap<>();
        String userID = mapper.findID(email);

        map.put("result", userID == null ? false : true);
        map.put("message", userID == null ? "찾으시는 아이디가 없습니다." : "찾으시는 아이디는\n" + userID + "\n입니다.");
        return map;
    }

    /**
     * 아이디와 이메일로 idx 찾고 임시비밀번호 발급
     * @param changePwRequest
     * @return
     */
    public Object changePW(ChangePwRequest changePwRequest) {
        MemberVO memberVO = MemberVO.builder()
                .email(changePwRequest.getEmail())
                .userID(changePwRequest.getUserID())
                .build();
        Long idx = mapper.findPW(memberVO);

        HashMap<String, Object> map = new HashMap<>();

        // row가 없으면 계정 못찾는 메시지 리턴
        if (idx == null) {
            map.put("result", false);
            map.put("message", "계정을 찾을 수 없습니다.");
            return map;
        }

        // 계정이 있으면 랜덤하게 문자열을 생성해서 idx값에 해당하는 비밀번호 변경
        String randomPw = StringUtil.generateRandomString(6);

        // 기존에 memberShipVO가 있기때문에 별도로 생성 하지 않고 기존 변수명 활용
        memberVO = MemberVO.builder()
                .password(passwordEncoder.encode(randomPw))
                .idx(idx).build();
        mapper.updatePW(memberVO);

        // 완료 메시지에 비밀번호를 넣어서 리턴
        map.put("result", true);
        map.put("message", randomPw);

        return map;
    }

}

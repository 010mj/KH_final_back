package kr.re.kh.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.re.kh.vo.MemberVO;

@Repository
public class MemberMapper {

    @Autowired
    private SqlSession session;

    public List<MemberVO> selectList(MemberVO memberVO){
        return session.selectList("member.selectList");
    }

    /**
     * 회원 정보
     * @param memberVO
     * @return
     */
    public MemberVO selectOne(MemberVO memberVO) {
        return session.selectOne("member.selectOne", memberVO);
    }

    /**
     * 회원 저장
     * @param memberVO
     */
    public void insert(MemberVO memberVO) {
        session.insert("member.insert", memberVO);
    }

    /**
     * 아이디 중복 체크
     * @param userID
     * @return
     */
    public int checkUserID(String userID) {
        return session.selectOne("member.checkUserID", userID);
    }

    /**
     * email 중복 체크
     * @param email
     * @return
     */
    public int checkEmail(String email) {
        return session.selectOne("member.checkEmail", email);
    }

    /**
     * 이메일로 아이디 찾기
     * @param email
     * @return
     */
    public String findID(String email) {
        return session.selectOne("member.findID", email);
    }

    /**
     * 아이디와 이메일로 사용자의 PK값 얻어내기
     * @param memberVO
     * @return
     */
    public Long findPW(MemberVO memberVO) {
        return session.selectOne("member.findPW", memberVO);
    }

    /**
     * PK값으로 비밀번호 변경
     * @param memberVO
     */
    public void updatePW(MemberVO memberVO) {
        session.update("member.updatePW", memberVO);
    }

    /**
     * 회원정보 변경시 본인 이메일 중복 제외 체크
     * @param userID
     * @return
     */
    public MemberVO updateEmailCheck(String userID) {
        return session.selectOne("member.updateEmailCheck", userID);
    }

    public Long selectUser(String userID) {
        return session.selectOne("member.selectUser", userID);
    }

    public Long findUser(MemberVO memberVO) {
        return session.selectOne("member.findUser", memberVO);
    }

    public void updateInfo(MemberVO memberVO) {
        session.update("member.updateInfo", memberVO);
    }

    public void withdraw(Long idx) {
        session.update("member.withdraw", idx);
    }
}

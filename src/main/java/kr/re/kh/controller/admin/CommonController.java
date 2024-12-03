package kr.re.kh.controller.admin;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.re.kh.payload.request.ChangePwRequest;
import kr.re.kh.payload.request.JoinRequest;
import kr.re.kh.service.impl.MemberService;
import kr.re.kh.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * test2
 */
@Controller
@Slf4j
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class CommonController {

    @Autowired
    private MemberService memberService;

//    // 로그인 페이지
//    @RequestMapping("/login")
//    public ModelAndView login(
//            @RequestParam(value = "userID", required = false, defaultValue = "") String userID,
//            @RequestParam(value = "password", required = false, defaultValue = "") String password) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
//        mav.addObject("userID", userID);
//        mav.addObject("password", password);
//        return mav;
//    }
//
//    @PostMapping("/loginProc")
//    public ModelAndView loginProc(
//            @ModelAttribute MemberVO memberVO, HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
//        MemberVO result = memberService.selectOne(memberVO);
//        if (result != null) {
//            log.info("로그인 성공");
//            HttpSession session = request.getSession();
//            session.setAttribute("userInfo", result);
//
//            String redirectUrl = (String) session.getAttribute("redirectUrl");
//            if (redirectUrl != null) {
//                mav.setViewName("redirect:" + redirectUrl);  // 세션에 저장된 URL로 리다이렉트
//                session.removeAttribute("redirectUrl");  // 리다이렉트 후 세션에서 URL 삭제
//            } else {
//                mav.setViewName("redirect:/");  // 기본 페이지로 리다이렉트
//            }
//
//        } else {
//            log.info("로그인 실패");
//            mav.setViewName("forward:/login");
//        }
//        return mav;
//    }
//
//    /**
//     * 로그아웃
//     * @param request
//     * @return
//     */
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        // 세션 삭제
//        session.invalidate();
//        return "redirect:/";
//    }
//
//    /**
//     * 회원가입 양식
//     * @return
//     */
//    @GetMapping("/join")
//    public ModelAndView join() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("join");
//        return mav;
//    }
//
//    /**
//     * 회원가입 처리
//     * @param memberVO
//     */
//    @PostMapping("/joinProc")
//    public String joinProc(@ModelAttribute MemberVO memberVO) {
//        memberService.insert(memberVO);
//        return "redirect:/login";
//    }
//
//    /**
//     * 회원가입 비동기 처리
//     * @param joinRequest
//     * @RequestBody 어노테이션이 있어야 post형식의 데이터를 받을 수 있다
//     * @return
//     */
//    @PostMapping("/joinProc2")
//    @ResponseBody
//    public ResponseEntity<?> joinProc2(@RequestBody JoinRequest joinRequest) {
//        log.info(joinRequest.toString());
//        return ResponseEntity.ok(memberService.memberJoin(joinRequest));
//    }

    /**
     * 비동기 통신 아이디 중복 확인
     * @return
     */
    @GetMapping("/checkUserID/{userID}")
    @ResponseBody
    public ResponseEntity<?> checkUserID(
            @PathVariable(value = "userID") String userID
    ) {
        HashMap<String, Object> result = memberService.checkUserID(userID);

        return ResponseEntity.ok(result);
    }

    /**
     * 비동기 통신 이메일 중복 확인
     * @param email
     * @return
     */
    @GetMapping("/checkEmail/{email}")
    @ResponseBody
    public ResponseEntity<?> checkEmail(
            @PathVariable(value = "email") String email
    ) {
        HashMap<String, Object> result = memberService.checkEmail(email);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findID")
    public String findID() {
        return "findID";
    }

    /**
     * 이메일로 아이디 찾기
     * @param email
     * @return
     */
    @GetMapping("/findID/{email}")
    @ResponseBody
    public ResponseEntity<?> findIDByEmail(
            @PathVariable(value = "email") String email
    ) {
        HashMap<String, Object> result = memberService.findID(email);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findPW")
    public String findPW() {
        return "findPW";
    }

    /**
     * 비밀번호 찾기에서 임시비밀번호 발급하기
     * @param changePwRequest
     * @return
     */
    @PostMapping("/changePW")
    @ResponseBody
    public ResponseEntity<?> changePW(
            @RequestBody ChangePwRequest changePwRequest) {
        return ResponseEntity.ok(memberService.changePW(changePwRequest));
    }

    /**
     * 회원정보 수정 본인 이메일 중복 확인
     * @param email
     * @return
     */
    @GetMapping("/isEmailAvailable/{email}")
    @ResponseBody
    public ResponseEntity<?> isEmailAvailable(
            @PathVariable(value = "email") String email, HttpServletRequest request
    ) {
        HashMap<String, Object> result = memberService.isEmailAvailable(email, request);
        return ResponseEntity.ok(result);
    }

}

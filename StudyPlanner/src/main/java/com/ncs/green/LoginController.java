package com.ncs.green;

/*
 *  [2ndrow::left] 로그인에 대한 내용들을 정리하고 추가한 controller입니다.
 *
 * */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.StudentService;
import vo.StudentVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	@Qualifier("student")
	private StudentService service;

	// 로그인
	@RequestMapping(value = "/login")
	public ModelAndView mlogin(HttpServletRequest request, ModelAndView mv, StudentVO vo) {
		String id = vo.getId();
		String password = vo.getPassword();

		HttpSession session = request.getSession();

		vo = service.loginCheck(vo);

		if (vo != null && vo.getSeq()==1) {              //이메일 인증 완료한 회원
			session.setAttribute("id", vo.getId());
			mv.setViewName("indexMenu"); // 로그인 성공시 화면이동
		} else {
			if(vo != null && vo.getSeq()>999) {           //가입은 했으나 이메일 인증 안한 회원
				mv.addObject("Check","NoEmail");
				mv.setViewName("login/loginFail"); // 로그인 실패
			} else {                                      //둘다 아님 (로그인 실패)
				mv.addObject("Check","Fail");
				mv.setViewName("login/loginFail"); // 로그인 실패
			}
		}
		return mv;
	} // login

	// 사이트 소개 페이지(introduce.jsp) 매핑
	@RequestMapping(value = "/siteIntro")
	public ModelAndView ploginf(ModelAndView mv) {
		mv.setViewName("introduce");
		return mv;
	}

}

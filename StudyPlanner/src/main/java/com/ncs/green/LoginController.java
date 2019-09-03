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

		if (vo != null) {
			session.setAttribute("id", vo.getId());
			mv.setViewName("login/loginSuccess"); // 로그인 성공시 화면이동
		} else {
			mv.setViewName("login/loginFail"); // 로그인 실패
		}
		return mv;
	} // login

	// 사이트 소개 페이지(introduce.jsp) 매핑
	@RequestMapping(value = "/siteIntro")
	public ModelAndView ploginf(ModelAndView mv) {
		mv.setViewName("login/introduce");
		return mv;
	}

}

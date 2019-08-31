package com.ncs.green;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.StudentService;
import vo.StudentVO;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("student")
	private StudentService service;
	
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value="/studentDetail")
	public ModelAndView studentDetail(HttpServletRequest request,
			ModelAndView mv, StudentVO vo) {
		
		String id = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("id");
			if (id != null) {
				mv.addObject("student", vo);
			} else
				System.out.println("**** loginID 값 null ****");
		} else
			System.out.println("**** session 값 null ****");
		
		if (vo != null && id != null) {
			mv.setViewName("login/detailView");
		} else { 
			mv.setViewName("login/loginFail"); //@@@@@여기 수정해주기 @@@@@
		}
		return mv; 
	}
	
	@RequestMapping(value="/studentUpdate")
	public ModelAndView mupdate(ModelAndView mv, StudentVO vo) {
		
		int cnt =  service.update(vo);
		if (cnt > 0) {
			// 수정성공
			mv.setViewName("login/loginSuccess"); //@@@@@여기 수정해주기 @@@@@
		} else {
			// 수정실패
			mv.setViewName("login/loginfail"); //@@@@@여기 수정해주기 @@@@@
		} 
		return mv;
	} // studentUpdate
	


	
}
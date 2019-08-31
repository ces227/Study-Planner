package com.ncs.green;

import javax.servlet.http.HttpServletRequest;

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
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("student")
	private StudentService service;
	
	@RequestMapping(value="/termsf")
	public ModelAndView termsf(ModelAndView mv) {
		mv.setViewName("login/terms");
		return mv;
	} //termsf

	@RequestMapping(value="/termsDetail")
	public ModelAndView termsDetail(ModelAndView mv) {
		mv.setViewName("login/termsDetail");
		return mv;
	} //termsDetail
	
	@RequestMapping(value="/joinf")
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("login/join");
		return mv;
	} //joinf
	
	@Autowired
	private UserMailSendService mailsender;

	@RequestMapping(value="/studentInsert") //회원 가입
	public ModelAndView studentInsert(ModelAndView mv, StudentVO vo,HttpServletRequest request) {
		
		int cnt=service.insert(vo);                //DB에 insert하기
		vo.setSeq(service.selectSeq(vo).getSeq()); //DB에서 seq값을 만들어줬기 때문에 java에서 seq값을 알수 있도록 set해준다
		if(cnt>0) {
			mailsender.mailSendWithUserKey(vo.getId(),vo.getName(), vo.getSeq(),request);  //id,name,seq를 넘겨준다
			System.out.println("**********가입성공**********");
			mv.setViewName("login/loginSuccess");
		}else {
			System.out.println("**********가입 실패**********");
			mv.setViewName("login/loginFail");
		}
		return mv;
	} //studentInsert
	
	@RequestMapping(value="/joinSuccess")
	public ModelAndView joinSucess(ModelAndView mv,StudentVO vo) {
		
		int cnt = service.updateConfirm(vo);
		if(cnt>0) {
			mv.setViewName("login/joinSuccess");			
		} else {
			mv.setViewName("login/loginFail");
		}
		return mv;
	} //joinSucess
	
	@RequestMapping(value="/idcheck")
	public ModelAndView idcheck(ModelAndView mv, StudentVO vo) {
		// DB 확인
		mv.addObject("id",vo.getId()) ;
		vo=service.selectOne(vo);
		if (vo!=null) { // 사용 불가능
			mv.addObject("idCheck","F");
		}else { // 사용가능
			mv.addObject("idCheck","T");
		}
		// 결과 출력
		mv.setViewName("login/idCheck");
		return mv;
	} // idcheck
}

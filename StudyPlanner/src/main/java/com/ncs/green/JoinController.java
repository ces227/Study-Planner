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
	//sdaflkadfslkjhgfkjhgfsdkj
	@RequestMapping(value="/joinf")
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("login/join");
		return mv;
	} //joinf
	
	@Autowired
	private UserMailSendService mailsender;

	@RequestMapping(value="/studentInsert") //�쉶�썝 媛��엯
	public ModelAndView studentInsert(ModelAndView mv, StudentVO vo,HttpServletRequest request) {
		
		int cnt=service.insert(vo);                //DB�뿉 insert�븯湲�
		vo.setSeq(service.selectSeq(vo).getSeq()); //DB�뿉�꽌 seq媛믪쓣 留뚮뱾�뼱以ш린 �븣臾몄뿉 java�뿉�꽌 seq媛믪쓣 �븣�닔 �엳�룄濡� set�빐以��떎
		if(cnt>0) {
			mailsender.mailSendWithUserKey(vo.getId(),vo.getName(), vo.getSeq(),request);  //id,name,seq瑜� �꽆寃⑥��떎
			System.out.println("**********媛��엯�꽦怨�**********");
			mv.setViewName("login/loginSuccess");
		}else {
			System.out.println("**********媛��엯 �떎�뙣**********");
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
		// DB �솗�씤
		mv.addObject("id",vo.getId()) ;
		vo=service.selectOne(vo);
		if (vo!=null) { // �궗�슜 遺덇��뒫
			mv.addObject("idCheck","F");
		}else { // �궗�슜媛��뒫
			mv.addObject("idCheck","T");
		}
		// 寃곌낵 異쒕젰
		mv.setViewName("login/idCheck");
		return mv;
	} // idcheck
}

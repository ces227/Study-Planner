package com.ncs.green;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.CalendarService;
import vo.CalendarVO;

@Controller
public class CalendarController {

	@Autowired
	@Qualifier("calendar")
	private CalendarService service;
	
	@RequestMapping(value="/CalendarMain") //member Detail
	public ModelAndView CalendarMain(HttpServletRequest request, 
			ModelAndView mv, CalendarVO vo, ArrayList<CalendarVO> avo) {
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id!=null) {
				vo.setCaid(id);
				avo=service.selectList(vo);
				int size=service.listCount(vo);
				mv.addObject("size",size);
				mv.addObject("loginIDcalendar",avo);
			}else {
				System.out.println("***** loginID null *****");
			}
		}else {
			System.out.println("***** session null *****");
		}
		mv.setViewName("calendar/mainCalendar");
		return mv;
	}
	
	@RequestMapping(value="/CalendarUpdate")
	public ModelAndView CalendarUpdate(HttpServletRequest request, ModelAndView mv, CalendarVO vo) {
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id!=null) {
				vo.setCaid(id);
			}
		}
		int cnt=0;
		cnt=service.update(vo);
		if(cnt>0) {
			System.out.println("*****업데이트 성공*****");
			mv.setViewName("calendar/mainCalendar");
		}else {
			System.out.println("*****업데이트 실패*****");
			mv.setViewName("calendar/mainCalendar");
		}
		return mv;
	}
	
	@RequestMapping(value="/CalendarInsert")
	public ModelAndView CalendarInsert(HttpServletRequest request, ModelAndView mv, CalendarVO vo) {
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id!=null) {
				vo.setCaid(id);
			}
		}
		int cnt=0;
		System.out.println(vo);
		cnt=service.insert(vo);
		if(cnt>0) {
			System.out.println("*****Calendar insert 성공*****");
			mv.setViewName("calendar/mainCalendar");
		}else {
			System.out.println("*****Calendar insert 실패*****");
			mv.setViewName("calendar/mainCalendar");
		}
		return mv;
	}
}

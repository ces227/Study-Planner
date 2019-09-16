package com.ncs.green;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.GgraphService;
import vo.GgraphVO;

@Controller
public class GgraphController {
	
	@Autowired
	@Qualifier("ggraph")
	private GgraphService service;
	
	@RequestMapping(value="/GgraphMain") //member Detail
	public ModelAndView CalendarMain(HttpServletRequest request, 
			ModelAndView mv, GgraphVO vo, ArrayList<GgraphVO> gvo) {
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id!=null) {
				vo.getGraID();
				gvo=service.selectList(vo);
				int size = gvo.size();
				mv.addObject("size", size);
				mv.addObject("", gvo);
			}else {
				System.out.println("***** loginID null *****");
			}
		}else {
			System.out.println("***** session null *****");
		}
		mv.setViewName("graph/graph");
		return mv;
	}
	
	@RequestMapping(value="/GgraphDetail") //member Detail
	public ModelAndView GgraphDetail(HttpServletRequest request, 
			ModelAndView mv, GgraphVO vo) {
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id!=null) {
				vo.setGraID(id);
				ArrayList<GgraphVO> gvo = service.selectList(vo);
				gvo=service.selectList(vo);
				mv.addObject("Ggraph", gvo);
				if(gvo.size()==0) {
					mv.addObject("Ggraphempty", "True");					
				}
			}else {
				System.out.println("***** loginID null *****");
			}
		}else {
			System.out.println("***** session null *****");
		}
		mv.setViewName("graph/insertgraph");
		return mv;
	}
	
	@RequestMapping(value="/GgraphDelete")
	public ModelAndView GgraphDelete(HttpServletRequest request, ModelAndView mv, GgraphVO vo) {
		System.out.println(vo);
		String id=null;
		HttpSession session = request.getSession(false);
		if(session!=null) {
			id=(String)session.getAttribute("id");
			if(id==null) {
				System.out.println("*****id is null****");
			}
		}
		int cnt=0;
		cnt=service.delete(vo);
		if(cnt>0) {
			System.out.println("*****Ggraph Delete Success*****");
			mv.setViewName("");
		}else {
			System.out.println("*****Ggraph Delete Fail*****");
			mv.setViewName("");
		}
		return mv;
	}
	
	@RequestMapping(value="/Ggraphupdate")
	public ModelAndView Ggraphupdate(HttpServletRequest request, ModelAndView mv, Map<String,GgraphVO> map,GgraphVO vo) {
		HttpSession session = request.getSession(false);
		String id=null;
		int cnt=0;
		if(session!=null) {
			id=(String)session.getAttribute("id");
		}
		vo.setGraID(id);
		String[] arrSeq=map.get("ggraphVO").getSeq().split(",");
		String[] arrName=map.get("ggraphVO").getExam_name().split(",");
		String[] arrDate=map.get("ggraphVO").getExam_date().split(",");
		String[] arrsubject=map.get("ggraphVO").getExam_subject().split(",");
		String[] arrGrade=map.get("ggraphVO").getExam_grade().split(",");
		
		for (int i = 0; i < arrSeq.length; i++) {
			vo.setSeq(arrSeq[i]);
			vo.setExam_name(arrName[i]);
			vo.setExam_date(arrDate[i]);
			vo.setExam_subject(arrsubject[i]);
			vo.setExam_grade(arrGrade[i]);
			System.out.println(vo.toString());
			cnt=service.update(vo);
			if (cnt>0) {
				System.out.println(i+"***성공***");
			} else {
				System.out.println(i+"***실패***");
			}
		}
		for (int i=arrSeq.length ; i< arrName.length; i++) {
			vo.setExam_name(arrName[i]);
			vo.setExam_date(arrDate[i]);
			vo.setExam_subject(arrsubject[i]);
			vo.setExam_grade(arrGrade[i]);
			System.out.println(vo.toString());
			cnt=service.insert(vo);
			if (cnt>0) {
				System.out.println(i+"***성공***");
			} else {
				System.out.println(i+"***실패***");
			}
		}
		
		mv.setViewName("redirect:GgraphMain");
		
		return mv;
	}
	


}

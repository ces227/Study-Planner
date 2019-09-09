package com.ncs.green;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.GgraphService;
import vo.GgraphVO;

@Controller
public class GgraphController {
	
	@Autowired
	@Qualifier("Ggraph")
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
				
			}else {
				System.out.println("***** loginID null *****");
			}
		}else {
			System.out.println("***** session null *****");
		}
		mv.setViewName("graph/graph");
		return mv;
	}

}

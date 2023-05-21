package com.kosta.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.board.DAO.MemberDAO;
import com.kosta.board.DTO.MemberDTO;
import com.kosta.board.Service.MemberService;

public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping(value= "/joinform", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView join(MemberDTO member) {
		ModelAndView mav = new ModelAndView();
		try {
			memberservice.memberAdd(member);
			mav.setViewName("redirect:/");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}

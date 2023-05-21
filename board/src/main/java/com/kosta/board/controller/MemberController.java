package com.kosta.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.board.DTO.MemberDTO;
import com.kosta.board.Service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value= "joinform", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberDTO member) {
		ModelAndView mav = new ModelAndView();
		try {
			memberservice.join(member);
			mav.setViewName("redirect:/");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "회원가입 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value= "loginform", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String id, @RequestParam String password) {
		ModelAndView mav = new ModelAndView();
		try {
			memberservice.login(id, password);
			httpSession.setAttribute("id", id);
			mav.setViewName("redirect:/");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "로그인 실패");
			mav.setViewName("err");
		}
		return mav;
	}
}

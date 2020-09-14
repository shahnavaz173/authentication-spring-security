package com.saiyad.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping({"/","index"})
	public ModelAndView goHome(){
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		if(principle instanceof UserDetails){
			String userName = ((UserDetails)principle).getUsername();
			modelAndView.addObject("loginUser", userName);
		}
		return modelAndView;
	}
	@GetMapping("/login")
	public String goLogin(Model model){
		
		return "login";
	}
	@GetMapping("/data")
	public ModelAndView data(){
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("data");
		if(principle instanceof UserDetails){
			String userName = ((UserDetails)principle).getUsername();
			modelAndView.addObject("loginUser", userName);
		}
		return modelAndView;
	}
	@GetMapping("/logout-success")
	public String logout(Model model){
		return "logout-success";
	}
}

package com.saiyad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saiyad.auth.User;
import com.saiyad.auth.UserRepository;



@Controller
public class RegistrationController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("createUser") User user, Model model){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(!userRepository.isUserExists(user.getUsername())){
			userRepository.createUser(user);
			model.addAttribute("userCreated","User Registration Successful.");
			return "login";
		}else{
			model.addAttribute("REGISTRATION_ERROR","User already Exist with username: "+user.getUsername());
			return "registration";
		}
	}
}

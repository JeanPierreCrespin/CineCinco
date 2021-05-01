package com.QuintoTrainee.CineCinco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
}

package com.QuintoTrainee.CineCinco.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QuintoTrainee.CineCinco.models.UsuarioModel;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainController {
 
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/butaca")
	public String butaca() {
		return "butaca.html";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio.html";
	}
	
	@GetMapping("/pago")
	public String pago() {
		return "pago.html";
	}
	
	@GetMapping("/peliculas")
	public String peliculas() {
		return "peliculas.html";
	}
	
	@GetMapping("/registro")
	public String registro(ModelMap modelo) {
		modelo.addAttribute("usuario", new UsuarioModel());
		return "registro.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
}

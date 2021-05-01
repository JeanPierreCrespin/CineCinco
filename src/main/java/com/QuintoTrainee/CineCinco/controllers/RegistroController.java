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
public class RegistroController {

	@GetMapping("/registro")
	public String registro(ModelMap modelo) {
		modelo.addAttribute("usuario", new UsuarioModel());
		return "/TestBack/registro.html";
	}
	
}
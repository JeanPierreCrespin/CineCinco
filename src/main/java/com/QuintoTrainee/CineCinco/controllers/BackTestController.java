package com.QuintoTrainee.CineCinco.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.enums.Rol;
import com.QuintoTrainee.CineCinco.models.UsuarioModel;
import com.QuintoTrainee.CineCinco.services.UsuarioService;
import com.QuintoTrainee.CineCinco.utils.UtilDate;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/BACK/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BackTestController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	//REGISTRO
	@GetMapping("/registro")
	public String registro(ModelMap modelo) {
		modelo.addAttribute("usuario", new UsuarioModel());
		return "/TestBack/registro.html";
	}
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(ModelMap modelo,
			@Valid @ModelAttribute("usuario") UsuarioModel usuarioModel, 
			@RequestParam(required = true) String password,
			@RequestParam(required = true) String repeated_password,
			@RequestParam(required = true) String fecha_nacimiento) throws Exception {

		try {
			usuarioModel.setRol(Rol.CLIENTE);
			usuarioModel.setFechaNacimiento(UtilDate.parseFechaGuiones(fecha_nacimiento));
			usuarioService.guardar(usuarioModel, password, repeated_password);
		} catch (Exception ex) {
			return "redirect:/BACK/registro?error=" + ex.getMessage();
		}

		return "redirect:/BACK/registro";
	}
	
	//LOGIN
	@GetMapping("/login")
    public String login(ModelMap modelo) {
        return "/TestBack/login.html";
    }
	
}

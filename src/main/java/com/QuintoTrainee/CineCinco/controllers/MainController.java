package com.QuintoTrainee.CineCinco.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.converters.UsuarioConverter;
import com.QuintoTrainee.CineCinco.entities.Usuario;
import com.QuintoTrainee.CineCinco.enums.Rol;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.UsuarioModel;
import com.QuintoTrainee.CineCinco.repositories.UsuarioRepository;
import com.QuintoTrainee.CineCinco.services.UsuarioService;
import com.QuintoTrainee.CineCinco.utils.UtilDate;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	private UsuarioConverter usuarioConverter;
	
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
	

	// REGISTRO
	@GetMapping("/registro")
	public String registro(ModelMap modelo) {
		modelo.addAttribute("usuario", new UsuarioModel());
		return "registro.html";
	}

	@PostMapping("/registro")
	public String registrarUsuario(ModelMap modelo, @Valid @ModelAttribute("usuario") UsuarioModel usuarioModel,
			@RequestParam(required = true) String password, @RequestParam(required = true) String repeated_password,
			@RequestParam(required = true) String fecha_nacimiento) throws Exception {

		try {
			usuarioModel.setRol(Rol.CLIENTE);
			usuarioModel.setFechaNacimiento(UtilDate.parseFechaGuiones(fecha_nacimiento));
			usuarioService.guardar(usuarioModel, password, repeated_password);
		} catch (Exception ex) {
			modelo.addAttribute("usuario",usuarioModel);
			modelo.addAttribute("error", ex.getMessage());
			return "registro" ;
		}

		return "index";
	}
	



	// LOGIN
	@GetMapping("/login")
	public String login(HttpSession session, Authentication usuario, ModelMap modelo,
			@RequestParam(required = false) String error) throws WebException {
		try {
			if (usuario.getName() != null) {
				return "/inicio";
			} else {

				if (error != null && !error.isEmpty()) {
					modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
				}
				return "login";
			}
		} catch (Exception e) {
			if (error != null && !error.isEmpty()) {
				modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
			}
			return "login";
		}
		//UsuarioModel usuario = usuarioConverter.entityToModel(usuarioRepository.getOne(((Usuario) session.getAttribute("usuarioSession")).getId()));
		//modelo.addAttribute("usuario", usuario);

	}
	
	@GetMapping("/loginsuccess")
	public String loginresolver() {
		return "/inicio.html";
	}
}

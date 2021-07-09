package com.QuintoTrainee.CineCinco.controllers;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.enums.Genero;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.PeliculaModel;
import com.QuintoTrainee.CineCinco.models.UsuarioModel;
import com.QuintoTrainee.CineCinco.services.PeliculaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ABM")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ABMController {

	@Autowired
	private PeliculaService peliculaService;

	// PELICULAS

	@GetMapping("/gestor_peliculas")
	public String GestorPeliculas(ModelMap modelo) {
		try {

			List<PeliculaModel> peliculas = peliculaService.listarPeliculasActivasModels();
			modelo.addAttribute("peliculas", peliculas);

			modelo.addAttribute("pelicula", new PeliculaModel());

			Set<Genero> generos = EnumSet.allOf(Genero.class);
			modelo.put("generos", generos);

		} catch (WebException e) {
			e.printStackTrace();
		}

		return "/TestBack/GestorPelicula.html";
	}

	@PostMapping("/agregarPelicula")
	public String agregarPelicula(ModelMap modelo, @Valid @ModelAttribute("pelicula") PeliculaModel peliculaModel) {

		try {
			peliculaService.guardar(peliculaModel);
			return "redirect:/TestBack/GestorPeliculas?estado=EXITO!";
		} catch (Exception ex) {
			modelo.put("error", ex.getMessage());
			return this.GestorPeliculas(modelo);
		}

	}

	@PostMapping("/eliminarPelicula")
	public String eliminarPelicula(ModelMap modelo, @RequestParam String idPelicula) {
		try {
			PeliculaModel peliculaModel = peliculaService.GetPeliculaModelById(idPelicula);
			peliculaService.softDelete(peliculaModel);
			return "redirect:/TestBack/GestorPeliculas?estado=EXITO!";
		} catch (Exception ex) {
			modelo.put("error", ex.getMessage());
			return this.GestorPeliculas(modelo);
		}
	}

	@PostMapping("/modificarPelicula")
	public String modificarPelicula(ModelMap modelo, @Valid @ModelAttribute("pelicula") PeliculaModel peliculaModel) {
		try {
			peliculaService.guardar(peliculaModel);
			return "redirect:/TestBack/GestorPeliculas?estado=EXITO!";
		} catch (Exception ex) {
			modelo.put("error", ex.getMessage());
			return this.GestorPeliculas(modelo);
		}
	}

	// SALAS
	
	@GetMapping("/gestor_salas")
	public String GestorSalas() {
		return "/TestBack/GestorSala.html";
	}
}

package com.QuintoTrainee.CineCinco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.QuintoTrainee.CineCinco.exceptions.WebException;

import com.QuintoTrainee.CineCinco.models.PeliculaModel;

import com.QuintoTrainee.CineCinco.services.PeliculaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PortadaController {
	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/portada/{idPelicula}")
	public String portada(ModelMap modelo, @PathVariable String idPelicula) {

		try {
			PeliculaModel pelicula = peliculaService.getPeliculaModelById(idPelicula);

			modelo.addAttribute("pelicula", pelicula);

		} catch (WebException e) {

			e.printStackTrace();
		}

		return "portada.html";
	}

}

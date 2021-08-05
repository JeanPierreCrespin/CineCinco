package com.QuintoTrainee.CineCinco.controllers;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.enums.Genero;
import com.QuintoTrainee.CineCinco.models.PeliculaModel;
import com.QuintoTrainee.CineCinco.services.PeliculaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PeliculaPorGeneroController {

	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/peliculasporgenero")
	public String peliculaporgenero(ModelMap modelo, @RequestParam(required = false) String genero) {

		try {
			List<PeliculaModel> peliculaxgenero;

			Set<Genero> generos = EnumSet.allOf(Genero.class);
			generos.remove(Genero.DESHABILITADOS);
			

			if (genero != null) {
				peliculaxgenero = peliculaService.listarPeliculasPorGenero(Genero.valueOf(genero));
			} else {
				peliculaxgenero = peliculaService.listarPeliculasActivasModels();
			}modelo.put("peliculas", peliculaxgenero);
		} catch (Exception ex) {
			modelo.put("error", ex.getMessage());
			
		}return "peliculasporgenero.html";
	}
}
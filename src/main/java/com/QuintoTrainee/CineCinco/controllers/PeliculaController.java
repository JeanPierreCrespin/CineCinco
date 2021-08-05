package com.QuintoTrainee.CineCinco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.PeliculaModel;
import com.QuintoTrainee.CineCinco.services.PeliculaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;


	@GetMapping("/peliculas")
	public String peliculas(ModelMap model) {
		List<PeliculaModel> estrenos;
		
		try {
			estrenos = peliculaService.listarEstrenos();
			model.put("estrenos", estrenos);
		} catch (WebException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "peliculas.html";
	}
	

}

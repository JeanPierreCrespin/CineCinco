package com.QuintoTrainee.CineCinco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.services.FuncionService;

public class FuncionController {

	@Autowired
	private FuncionService funcionService;
	
	@GetMapping("/seleccionar/{idFuncion}")
	public String seleccionar(ModelMap modelo, @PathVariable String idFuncion) {

		try {
			FuncionModel funcion = funcionService.getFuncionModelById(idFuncion);

			modelo.addAttribute("funcion", funcion);

		} catch (WebException e) {

			e.printStackTrace();
		}

		return "butaca_copy.html";
	}


	}


package com.QuintoTrainee.CineCinco.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.ButacaModel;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.services.FuncionService;
import static com.QuintoTrainee.CineCinco.utils.Texts.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ButacasController {

	@Autowired FuncionService funcionService;
	
	@GetMapping("/seleccionar/{idFuncion}")
	public String seleccionar(ModelMap model, @PathVariable String idFuncion) {
		
		try {
			FuncionModel funcion = funcionService.GetOneById(idFuncion);
			model.addAttribute("funcion", funcion);
			
			Map<Integer, ArrayList<ButacaModel>> filasMap = funcionService.obtenerMapButacasOrdenado(funcion);
			
			model.addAttribute("filasMap", filasMap);
			
			int cantFilas = funcionService.obtenerCantidadDeFilas(funcion) + 1;
			
			model.addAttribute("cantFilas", cantFilas);
			
		} catch (WebException e) {
			e.printStackTrace();
		}
		
		return "butaca_copy.html";
	}
	
}

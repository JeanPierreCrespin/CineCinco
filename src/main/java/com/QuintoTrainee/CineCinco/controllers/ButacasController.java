package com.QuintoTrainee.CineCinco.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.BoletoModel;
import com.QuintoTrainee.CineCinco.models.ButacaModel;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.services.ButacaService;
import com.QuintoTrainee.CineCinco.services.FuncionService;
import static com.QuintoTrainee.CineCinco.utils.Texts.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ButacasController {

	@Autowired FuncionService funcionService;
	@Autowired ButacaService butacaService;
	
	@GetMapping("/seleccionar/{idFuncion}")
	public String seleccionar(ModelMap model, @PathVariable String idFuncion) {
		
		try {
			FuncionModel funcion = funcionService.getFuncionModelById(idFuncion);
			model.addAttribute("funcion", funcion);
			
			Map<Integer, ArrayList<ButacaModel>> filasMap = funcionService.obtenerMapButacasOrdenado(funcion);
			
			model.addAttribute("filasMap", filasMap);
			
			int cantFilas = funcionService.obtenerCantidadDeFilas(funcion) + 1;
			
			model.addAttribute("cantFilas", cantFilas);
			
			FuncionModel funcionSeleccionButacas = new FuncionModel();
			model.addAttribute("funcionSeleccionButacas", funcionSeleccionButacas);
			
		} catch (WebException e) {
			e.printStackTrace();
		}
		
		return "butaca_copy.html";
	}
	
	@PostMapping("/test")
	public String test(ModelMap model, @Valid @ModelAttribute("funcionSeleccionButacas") FuncionModel funcionSeleccionButacas,
			@RequestParam(required = true) String idFuncion) {
		
		try {			
			ArrayList<BoletoModel> boletos = new ArrayList<BoletoModel>();
			
			for (String idButaca : funcionSeleccionButacas.getIdsButacas()) {
				BoletoModel boleto = new BoletoModel();
				
				boleto.setButaca(butacaService.getButacaModelById(idButaca));
				boleto.setFuncion(funcionService.getFuncionModelById(idFuncion));
				boleto.setAlta(new Date());
				
				boletos.add(boleto);
			}
			
			for (BoletoModel boletoModel : boletos) {
				System.out.println(boletoModel.getButaca().getNombre());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/seleccionar/"+idFuncion;
	}
	
}

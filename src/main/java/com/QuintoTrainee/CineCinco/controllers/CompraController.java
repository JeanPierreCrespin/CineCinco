package com.QuintoTrainee.CineCinco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.entities.Usuario;
import com.QuintoTrainee.CineCinco.services.CompraService;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Controller
@RequestMapping("/compra")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompraController {
	@Autowired
	private CompraService compraService;

	@PostMapping("/realizar_pago")
	public String crearPago(@RequestParam(required = false) String title,
			@RequestParam(required = false) double price, 
			@RequestParam(required = false) double total)
			throws MPException {

		Preference preference = new Preference();

		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle(title)
		.setQuantity(1)
		.setUnitPrice((float) price);

		preference.appendItem(item);
		BackUrls backUrls = new BackUrls(
				"http://localhost:8080/pago/save", 
				"http://localhost:8080/pago/realizar_pago",
				"http://localhost:8080/pago/realizar_pago");
		preference.setBackUrls(backUrls);
		var resulset = preference.save();

		return "redirect:" + resulset.getSandboxInitPoint();

	}

	@GetMapping("/save")
	public String save(@RequestParam String status, @RequestParam String payment_type) throws Exception {

		Usuario usuario = new Usuario();
		;// = Controllers.getFromSession(session);

		if (status.equals("approved")) {
			compraService.save(status, payment_type, usuario);

		}
		return "redirect:/?status=" + status;

	}

}

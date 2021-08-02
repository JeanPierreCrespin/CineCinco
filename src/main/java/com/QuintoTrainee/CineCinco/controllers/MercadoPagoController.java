package com.QuintoTrainee.CineCinco.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.GsonBuilder;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.advancedpayment.Identification;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

import lombok.RequiredArgsConstructor;
import lombok.var;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MercadoPagoController {
	
	
@PostMapping("/mp")	
public String crearPago() throws MPException {
	
	
	Preference preference = new Preference();

	// Crea un ítem en la preferencia
	Item item = new Item();
	item.setTitle("Mi producto")
	    .setQuantity(1)
	    .setUnitPrice((float) 75.56);
	
	preference.appendItem(item);
	var resulset= preference.save();
	System.out.println(resulset.getSandboxInitPoint());
	
	return "redirect:" + resulset.getSandboxInitPoint();
	
}

/*	@GetMapping("/createAndRedirect")
	public String createAndRedirect() throws Exception{
		Preference preference = new Preference();
		
		preference.setBackUrls(
				new BackUrls().setFailure("http://localhost/failure")
				.setPending("http://localhost/peding")
				.setSuccess("http://localhost/success"));
		
		Item item = new Item();
		item.setTitle("Mi producto")
		    .setQuantity(1)
		    .setUnitPrice((float) 75.56);
		preference.appendItem(item);
		var resulset= preference.save();
		System.out.println(resulset.getSandboxInitPoint());
		
		return "redirect"+resulset.getSandboxInitPoint();
	}
	
	@GetMapping("/success")
	public String success(HttpServletRequest request,
			@RequestParam("collection_id") String collectionId,
			@RequestParam("collection_status") String collectionStatus,
			@RequestParam("collection_reference") String collectionReference,
			@RequestParam("payment_type") String PaymentType,
			@RequestParam("merchant_order_id") String merchantOrderId,
			@RequestParam("preference_id") String preferenceId,
			@RequestParam("site_id") String siteId,
			@RequestParam("processing_mode") String processingMode,
			@RequestParam("merchant_account_id") String merchantAccountId,
			Model model) throws MPException{
		
		var payment = com.mercadopago.resources.Payment.findById(collectionId);
		
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(payment));
		
		model.addAttribute("payment",payment);
		
		return "Ok";
	}*/
}

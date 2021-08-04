package com.QuintoTrainee.CineCinco.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuintoTrainee.CineCinco.entities.Usuario;
import com.QuintoTrainee.CineCinco.models.BoletoModel;
import com.QuintoTrainee.CineCinco.models.ButacaModel;
import com.QuintoTrainee.CineCinco.models.CompraModel;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.services.ButacaService;
import com.QuintoTrainee.CineCinco.services.CompraService;
import com.QuintoTrainee.CineCinco.services.FuncionService;
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
	@Autowired
	private FuncionService funcionService;
	@Autowired
	private ButacaService butacaService;

	@PostMapping("/realizar_pago")
	public String crearPago(@RequestParam(required = true) String idFuncion,
			@RequestParam(required = true) String totalPagar, @RequestParam(required = true) List<String> idsButacas)
			throws MPException {

		System.out.println(idsButacas);
		System.out.println(totalPagar);
		System.out.println(idFuncion);

		CompraModel compraModel = new CompraModel();
		ArrayList<BoletoModel> boletos = new ArrayList<BoletoModel>();

		try {
			FuncionModel funcion = funcionService.getFuncionModelById(idFuncion);

			for (String idButaca : idsButacas) {
				ButacaModel butaca = butacaService.getButacaModelById(idButaca);
				BoletoModel boleto = new BoletoModel();

				boleto.setAlta(new Date());
				boleto.setFuncion(funcion);
				boleto.setButaca(butaca);

				boletos.add(boleto);
			}

			float precioTotal = (float) (boletos.size() * funcion.getPrecioEntrada());
			// SECCION MP

			Preference preference = new Preference();
			// Crea un ítem en la preferencia
			Item item = new Item();
			item.setTitle("Entradas para: " + funcion.getPelicula().getTitulo()).setQuantity(boletos.size())
					.setUnitPrice((float) funcion.getPrecioEntrada());

			preference.appendItem(item);
			BackUrls backUrls = new BackUrls("http://localhost:8080/compra/save",
					"http://localhost:8080/compra/realizar_pago", "http://localhost:8080/compra/realizar_pago");
			preference.setBackUrls(backUrls);
			var resulset = preference.save();
			return "redirect:" + resulset.getSandboxInitPoint();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

	@GetMapping("/save")
	public String save(@RequestParam String status, @RequestParam String payment_type) throws Exception {

		Usuario usuario = new Usuario();
		// = Controllers.getFromSession(session);
		System.out.println(status);

		if (status.equals("approved")) {
			// compraService.save(status, payment_type, usuario);
			System.out.println("APROBADO");
		}
		return "redirect:/?status=" + status;

	}

}

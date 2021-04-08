package com.QuintoTrainee.CineCinco.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CompraModel {

	private String id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaCompra;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaAprobacionPago;
	
	private List<BoletoModel> boletos;
	
	private double precioTotal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date alta;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date baja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modificacion;
	
}

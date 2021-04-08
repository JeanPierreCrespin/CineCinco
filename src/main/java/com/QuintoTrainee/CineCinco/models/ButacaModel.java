package com.QuintoTrainee.CineCinco.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ButacaModel {

	private String id;
	
	private String nombre;
	
	private boolean ocupado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date alta;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date baja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modificacion;
	
}

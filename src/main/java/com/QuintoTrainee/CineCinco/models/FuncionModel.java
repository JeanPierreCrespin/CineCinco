package com.QuintoTrainee.CineCinco.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.QuintoTrainee.CineCinco.enums.Idioma;

import lombok.Data;

@Data
public class FuncionModel {

	private String id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date horario;
	
	private Idioma idioma;
	
	private boolean idiomaExtranjero;
	
	private PeliculaModel pelicula;
	
	private SalaModel sala;
	
	private List<ButacaModel> butacas;
	
	private double precioEntrada;
	
	private int cantidadVacios;
	
	private int cantidadOcupados;
	
	private boolean llena;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date alta;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date baja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modificacion;
	
}

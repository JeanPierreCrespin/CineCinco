package com.QuintoTrainee.CineCinco.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.QuintoTrainee.CineCinco.enums.Idioma;

import lombok.Data;

@Data
public class FuncionModel implements Serializable {

	private static final long serialVersionUID = -7042903749511417665L;

	private String id;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha;

	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date horario;

	private Idioma idioma;

	private boolean idiomaExtranjero;

	private PeliculaModel pelicula;
	private String idPelicula;

	private SalaModel sala;
	private String idSala;

	private List<ButacaModel> butacas;
	private List<String> idsButacas;
	private String butacasSeleccionadas;
	
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

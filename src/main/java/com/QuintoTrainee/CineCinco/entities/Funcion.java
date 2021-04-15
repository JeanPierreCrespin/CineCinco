package com.QuintoTrainee.CineCinco.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.QuintoTrainee.CineCinco.enums.Idioma;

import lombok.Data;

@Data
@Entity
public class Funcion {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIME)
	private Date horario;

	@Enumerated(EnumType.STRING)
	private Idioma idioma;

	private boolean idiomaExtranjero;

	@ManyToOne
	private Pelicula pelicula;

	@ManyToOne
	private Sala sala;

	@OneToMany
	private List<Butaca> butacas;

	private double precioEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date baja;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

}

package com.QuintoTrainee.CineCinco.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.QuintoTrainee.CineCinco.enums.Estado;

import lombok.Data;

@Data
@Entity
public class Compra {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCompra;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacionPago;
	
	@OneToMany
	private List<Boleto> boletos;
	
	private double precioTotal;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date baja;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;
	
}

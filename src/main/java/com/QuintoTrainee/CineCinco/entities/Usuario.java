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

import com.QuintoTrainee.CineCinco.enums.Rol;

import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String userId;
	
	private String password;
	
	private String email;
	
	private String nombreUsuario;
	
	private String username;
	
	private Date fechaNacimiento;
	
	private String infoTarjeta;
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	@OneToMany
	private List<Compra> compras;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date baja;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;
	
}

package com.QuintoTrainee.CineCinco.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Rol rol;
	private String infoTarjeta;
	//private List<Ticket> compras;
	private Date alta;
	private Date baja;
	private Date modificacion;
	
}

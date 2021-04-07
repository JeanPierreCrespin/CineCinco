package com.QuintoTrainee.CineCinco.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Butaca {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String butacaId;
	
	private String nombreButaca;
	
	private boolean ocupado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date baja;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;
	
}

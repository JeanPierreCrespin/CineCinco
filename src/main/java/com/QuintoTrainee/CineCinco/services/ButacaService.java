package com.QuintoTrainee.CineCinco.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuintoTrainee.CineCinco.converters.ButacaConverter;
import com.QuintoTrainee.CineCinco.entities.Butaca;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.ButacaModel;
import com.QuintoTrainee.CineCinco.repositories.ButacaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ButacaService {

@Autowired
private ButacaRepository butacaRepository;
	
@Autowired
private ButacaConverter butacaConverter;
	
	public void hardDelete(ButacaModel model) {
		Butaca butaca= butacaRepository.getOne(model.getId());
		butacaRepository.delete(butaca);
	}
	
	public Butaca softDelete(ButacaModel model) {
		Butaca butaca = butacaRepository.getOne(model.getId());
		butaca.setBaja(new Date());
		return butacaRepository.save(butaca);
	}
	
	public Butaca guardar(ButacaModel model) throws WebException {
		
		validar(model);
		
		Butaca entity = butacaConverter.modelToEntity(model);
		
		if(entity.getAlta() != null) {
			entity.setModificacion(new Date());
		}else {
			entity.setAlta(new Date());
		}
		
		return butacaRepository.save(entity);
	}
	
	public void validar(ButacaModel butacaC) throws WebException {
		
		if (butacaC.getNombre() == null || butacaC.getNombre().isEmpty() || butacaC.getNombre().equals("")) {
			throw new WebException("La butaca debe tener un nombre");
		}
		
		if (butacaC.equals(butacaC) == true) {
			throw new WebException("La butaca esta ocupada");
		}
		
		Butaca butacaA = butacaRepository.buscarButacaPorId(butacaC.getId());
		
		if (butacaA != null && !(butacaA).getId().equals(butacaC.getId())) {
			throw new WebException("Ya existe una butaca con ese número");
		}
		
		try {
			
		} catch (IllegalArgumentException e) {
			throw new WebException("La butaca indicada no es una butaca valida");
		} catch (NullPointerException e) {
			throw new WebException("La butaca debe tener un número");
		}
		
	}     
	
}

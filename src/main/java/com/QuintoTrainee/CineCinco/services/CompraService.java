package com.QuintoTrainee.CineCinco.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuintoTrainee.CineCinco.converters.CompraConverter;
import com.QuintoTrainee.CineCinco.entities.Compra;
import com.QuintoTrainee.CineCinco.entities.Usuario;
import com.QuintoTrainee.CineCinco.enums.Estado;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.CompraModel;
import com.QuintoTrainee.CineCinco.repositories.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompraService {

	@Autowired
	private CompraConverter compraConverter;
	@Autowired
	private CompraRepository compraRepository;
	
	public void validar(CompraModel compraModel) throws WebException {
		
		try {
			Enum.valueOf(Estado.class, compraModel.getEstado().toString());
		} catch (IllegalArgumentException e) {
			throw new WebException("El estado indicado no es un estado valido");
		} catch (NullPointerException e) {
			throw new WebException("La compra debe tener un estado");
		}
	}
	
	public Compra guardar(CompraModel compraModel) throws WebException {
		
		validar(compraModel);
		
		Compra compraEntity = compraConverter.modelToEntity(compraModel);
		
		if (compraEntity.getAlta() != null) {
			compraEntity.setModificacion(new Date());
		} else {
			compraEntity.setAlta(new Date());
		}
		
		return compraRepository.save(compraEntity);
		
	}
	
	public void hardDelete(CompraModel compraModel) throws WebException {
		Compra compraEntity = compraConverter.modelToEntity(compraModel);
		compraRepository.delete(compraEntity);
	}
	
	public Compra softDelete(CompraModel compraModel) throws WebException {
		Compra compraEntity = compraConverter.modelToEntity(compraModel);
		compraEntity.setBaja(new Date());
		return compraRepository.save(compraEntity);
	}

	public void save(String status, String payment_type, Usuario usuario) {
		 Compra compra = new Compra();
		 
		
	}
	
}

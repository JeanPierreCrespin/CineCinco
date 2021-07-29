package com.QuintoTrainee.CineCinco.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuintoTrainee.CineCinco.converters.FuncionConverter;
import com.QuintoTrainee.CineCinco.entities.Funcion;
import com.QuintoTrainee.CineCinco.enums.Idioma;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.repositories.FuncionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionService {

	@Autowired
	private FuncionRepository funcionRepository;
	@Autowired
	private FuncionConverter funcionConverter;
	
	public void validar(FuncionModel funcionModel) throws WebException {
		
		if (funcionModel.getFecha() == null) {
			throw new WebException("La funcion debe contar con una fecha");
		}
		
		if (funcionModel.getHorario() == null) {
			throw new WebException("La funcion debe contar con un horario");
		}
		
		if (funcionModel.getPrecioEntrada() < 0) {
			throw new WebException("El precio de entrada indicado para la funcion es invalido");
		}
		
		try {
			Enum.valueOf(Idioma.class, funcionModel.getIdioma().toString());
		} catch (IllegalArgumentException e) {
			throw new WebException("El idioma indicado no es un idioma valido");
		} catch (NullPointerException e) {
			throw new WebException("La funcion debe contener un idioma");
		}
		
	}
	
	//persiste el modelo
	public Funcion guardar(FuncionModel funcionModel) {
		
		try {
			
			validar(funcionModel);
			System.out.println("antes de convertir la funcion");		
			Funcion funcionEntity = funcionConverter.modelToEntity(funcionModel);
			System.out.println("despues de convertir la funcion");
			
			if (funcionEntity.getAlta() != null) {
				funcionEntity.setModificacion(new Date());
			} else {
				funcionEntity.setAlta(new Date());
			}
			
			return funcionRepository.save(funcionEntity);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public void hardDelete(FuncionModel funcionModel) throws WebException {
		Funcion funcionEntity = funcionConverter.modelToEntity(funcionModel);
		funcionRepository.delete(funcionEntity);
	}
	
	public Funcion softDelete(String idFuncion) throws WebException {
		Funcion funcionEntity = funcionRepository.getOne(idFuncion);
		funcionEntity.setBaja(new Date());
		return funcionRepository.save(funcionEntity);
	}

	public List<FuncionModel> listarFuncionesActivasModels() throws WebException {
		return funcionConverter.entitiesToModels(funcionRepository.listarFuncionesActivas());
	}
	
}

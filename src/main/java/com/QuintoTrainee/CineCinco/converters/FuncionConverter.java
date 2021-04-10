package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Funcion;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.repositories.FuncionRepository;

import lombok.RequiredArgsConstructor;

@Component("FuncionConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionConverter extends Converter<FuncionModel, Funcion>{

	private final FuncionRepository funcionRepository;
	
	public Funcion modelToEntity(FuncionModel model) throws WebException {
		
		Funcion entity;
		
		if(model.getId() != null && model.getId().isEmpty()) {
			entity = funcionRepository.getOne(model.getId());
		}else {
			entity = new Funcion();
		}
		
		try {
			
			//faltan atributos Sala, Pelicula, Butacas
			
			BeanUtils.copyProperties(model, entity);
		} catch (Exception e) {
			throw new WebException("Error al convertir el modelo " + entity.toString() + " a entidad");
		}
		
		return entity;
	}

	@Override
	public FuncionModel entityToModel(Funcion entity) throws WebException {
		return null;
	}

	@Override
	public List<Funcion> modelsToEntities(List<FuncionModel> models) throws WebException {
		return null;
	}

	public List<FuncionModel> entitiesToModels(List<Funcion> entities) throws WebException {
		return null;
	}

}

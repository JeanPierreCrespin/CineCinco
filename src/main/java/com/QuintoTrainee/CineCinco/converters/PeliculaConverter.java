package com.QuintoTrainee.CineCinco.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Pelicula;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.PeliculaModel;
import com.QuintoTrainee.CineCinco.repositories.PeliculaRepository;

import lombok.RequiredArgsConstructor;

@Component("PeliculaConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PeliculaConverter extends Converter<PeliculaModel, Pelicula>{

	private final PeliculaRepository peliculaRepository;
	
	public Pelicula modelToEntity(PeliculaModel model) throws WebException {
		
		Pelicula entity;
		
		if(model.getId() != null && !model.getId().isEmpty()) {
			entity = peliculaRepository.getOne(model.getId());
		}else {
			entity = new Pelicula();
		}
		
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (Exception e) {
			throw new WebException("Error al convertir el modelo " + entity.toString() + " a entidad");
		}
		
		return entity;
	}

	public PeliculaModel entityToModel(Pelicula entity) throws WebException {
		
		PeliculaModel model = new PeliculaModel();
		
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (Exception e) {
			throw new WebException("Error al convertir la entidad " + entity.toString() + " a modelo");
		}
		
		return model;
	}

	public List<Pelicula> modelsToEntities(List<PeliculaModel> models) throws WebException {
		
		List<Pelicula> entities = new ArrayList<>();
		
		for(PeliculaModel model : models) {
			entities.add(modelToEntity(model));
		}
		
		return entities;
	}

	public List<PeliculaModel> entitiesToModels(List<Pelicula> entities) throws WebException {
		
		List<PeliculaModel> models = new ArrayList<>();
		
		for(Pelicula entity : entities) {
			models.add(entityToModel(entity));
		}
		
		return models;
	}
	
}

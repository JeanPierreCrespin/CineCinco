package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Pelicula;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.PeliculaModel;

import lombok.RequiredArgsConstructor;

@Component("PeliculaConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PeliculaConverter extends Converter<PeliculaModel, Pelicula>{

	@Override
	public Pelicula modelToEntity(PeliculaModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PeliculaModel entityToModel(Pelicula e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> modelsToEntities(List<PeliculaModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeliculaModel> entitiesToModels(List<Pelicula> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

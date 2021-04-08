package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Butaca;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.ButacaModel;

import lombok.RequiredArgsConstructor;

@Component("ButacaConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ButacaConverter extends Converter<ButacaModel, Butaca> {

	@Override
	public Butaca modelToEntity(ButacaModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ButacaModel entityToModel(Butaca e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Butaca> modelsToEntities(List<ButacaModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ButacaModel> entitiesToModels(List<Butaca> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

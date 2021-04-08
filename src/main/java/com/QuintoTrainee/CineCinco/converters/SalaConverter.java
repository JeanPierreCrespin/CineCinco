package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Sala;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.SalaModel;

import lombok.RequiredArgsConstructor;

@Component("SalaConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SalaConverter extends Converter<SalaModel,Sala>{

	@Override
	public Sala modelToEntity(SalaModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaModel entityToModel(Sala e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sala> modelsToEntities(List<SalaModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalaModel> entitiesToModels(List<Sala> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Funcion;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.FuncionModel;

import lombok.RequiredArgsConstructor;

@Component("FuncionConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionConverter extends Converter<FuncionModel, Funcion>{

	@Override
	public Funcion modelToEntity(FuncionModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionModel entityToModel(Funcion e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcion> modelsToEntities(List<FuncionModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionModel> entitiesToModels(List<Funcion> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

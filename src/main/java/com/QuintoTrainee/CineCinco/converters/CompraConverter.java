package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Compra;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.CompraModel;

import lombok.RequiredArgsConstructor;

@Component("CompraConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompraConverter extends Converter<CompraModel, Compra> {

	@Override
	public Compra modelToEntity(CompraModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompraModel entityToModel(Compra e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> modelsToEntities(List<CompraModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraModel> entitiesToModels(List<Compra> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

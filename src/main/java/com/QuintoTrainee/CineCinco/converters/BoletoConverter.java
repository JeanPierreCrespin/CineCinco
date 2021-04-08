package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Boleto;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.BoletoModel;

import lombok.RequiredArgsConstructor;

@Component("BoletoConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BoletoConverter extends Converter<BoletoModel, Boleto>{

	@Override
	public Boleto modelToEntity(BoletoModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoletoModel entityToModel(Boleto e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boleto> modelsToEntities(List<BoletoModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoletoModel> entitiesToModels(List<Boleto> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

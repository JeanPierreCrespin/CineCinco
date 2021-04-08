package com.QuintoTrainee.CineCinco.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Usuario;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.UsuarioModel;

import lombok.RequiredArgsConstructor;

@Component("UsuarioConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioConverter extends Converter<UsuarioModel, Usuario>{

	@Override
	public Usuario modelToEntity(UsuarioModel m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioModel entityToModel(Usuario e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> modelsToEntities(List<UsuarioModel> m) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioModel> entitiesToModels(List<Usuario> e) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}

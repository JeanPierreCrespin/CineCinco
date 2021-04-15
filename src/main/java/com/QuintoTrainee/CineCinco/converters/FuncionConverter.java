package com.QuintoTrainee.CineCinco.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.QuintoTrainee.CineCinco.entities.Butaca;
import com.QuintoTrainee.CineCinco.entities.Funcion;
import com.QuintoTrainee.CineCinco.entities.Pelicula;
import com.QuintoTrainee.CineCinco.entities.Sala;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
import com.QuintoTrainee.CineCinco.models.ButacaModel;
import com.QuintoTrainee.CineCinco.models.FuncionModel;
import com.QuintoTrainee.CineCinco.repositories.ButacaRepository;
import com.QuintoTrainee.CineCinco.repositories.FuncionRepository;
import com.QuintoTrainee.CineCinco.repositories.PeliculaRepository;
import com.QuintoTrainee.CineCinco.repositories.SalaRepository;

import lombok.RequiredArgsConstructor;

@Component("FuncionConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionConverter extends Converter<FuncionModel, Funcion> {

	private final FuncionRepository funcionRepository;
	private final ButacaRepository butacaRepository;
	private final SalaRepository salaRepository;
	private final PeliculaRepository peliculaRepository;
	private final ButacaConverter butacaConverter;
	private final SalaConverter salaConverter;
	private final PeliculaConverter peliculaConverter;

	public Funcion modelToEntity(FuncionModel model) throws WebException {

		Funcion entity;

		if (model.getId() != null && !model.getId().isEmpty()) {
			entity = funcionRepository.getOne(model.getId());
		} else {
			entity = new Funcion();
		}

		try {

			Butaca entityButaca = null;
			List<Butaca> entityButacas = new ArrayList<>();

			if (model.getButacas() != null) {
				for (ButacaModel a : model.getButacas()) {

					entityButaca = butacaRepository.getOne(a.getId());

					entityButacas.add(entityButaca);
				}
			}

			entity.setButacas(entityButacas);

			Sala entitySala = null;
			if (model.getIdSala() != null) {
				entitySala = salaRepository.getOne(model.getId());

			}

			entity.setSala(entitySala);

			Pelicula entityPelicula = null;
			if (model.getIdPelicula() != null) {
				entityPelicula = peliculaRepository.getOne(model.getIdPelicula());
			}

			entity.setPelicula(entityPelicula);

			BeanUtils.copyProperties(model, entity);
		} catch (Exception e) {
			throw new WebException("Error al convertir el modelo " + entity.toString() + " a entidad");
		}

		return entity;
	}

	public FuncionModel entityToModel(Funcion entity) throws WebException {
		FuncionModel model = new FuncionModel();
		try {

			List<ButacaModel> modelButacas = new ArrayList<>();
			if (entity.getButacas() != null) {
				modelButacas = butacaConverter.entitiesToModels(entity.getButacas());

			}

			model.setButacas(modelButacas);

			if (entity.getSala() != null) {
				model.setIdSala(entity.getSala().getId());
				model.setSala(salaConverter.entityToModel(salaRepository.getOne(entity.getSala().getId())));
			}

			if (entity.getPelicula() != null) {
				model.setIdPelicula(entity.getPelicula().getId());
				model.setPelicula(peliculaConverter.entityToModel(entity.getPelicula()));
				// pregunta
			}

			BeanUtils.copyProperties(entity, model);
		} catch (Exception e) {
			throw new WebException("Error al convertir la entidad " + entity.toString() + " a modelo");
		}
		return model;
	}

	public List<Funcion> modelsToEntities(List<FuncionModel> m) throws WebException {
		List<Funcion> entities = new ArrayList<>();
		for (FuncionModel model : m) {
			entities.add(modelToEntity(model));
		}
		return entities;
	}

	public List<FuncionModel> entitiesToModels(List<Funcion> entities) throws WebException {
		List<FuncionModel> models = new ArrayList<>();
		for (Funcion a : entities) {
			models.add(entityToModel(a));
		}
		return models;
	}

}
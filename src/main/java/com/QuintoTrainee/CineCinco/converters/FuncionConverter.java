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
import com.QuintoTrainee.CineCinco.repositories.FuncionRepository;
import com.QuintoTrainee.CineCinco.repositories.PeliculaRepository;
import com.QuintoTrainee.CineCinco.repositories.SalaRepository;

import lombok.RequiredArgsConstructor;

@Component("FuncionConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionConverter extends Converter<FuncionModel, Funcion> {

	private final FuncionRepository funcionRepository;
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

			List<Butaca> entityButacas = new ArrayList<>();

			if (model.getButacas() != null) {
				butacaConverter.modelsToEntities(model.getButacas());
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
			List<String> idsButacas = new ArrayList<>();

			if (entity.getButacas() != null) {
				modelButacas = butacaConverter.entitiesToModels(entity.getButacas());
			}

			for (ButacaModel butacaModel : modelButacas) {
				idsButacas.add(butacaModel.getId());
			}

			model.setButacas(modelButacas);
			model.setIdsButacas(idsButacas);

			if (entity.getSala() != null) {
				model.setIdSala(entity.getSala().getId());
				model.setSala(salaConverter.entityToModel(salaRepository.getOne(entity.getSala().getId())));
			}

			if (entity.getPelicula() != null) {
				model.setIdPelicula(entity.getPelicula().getId());
				model.setPelicula(
						peliculaConverter.entityToModel(peliculaRepository.getOne(entity.getPelicula().getId())));
			}

			int cantidadVacios = 0, cantidadOcupados = 0;
			boolean llena = false;

			for (Butaca butaca : entity.getButacas()) {
				if (butaca.isOcupado()) {
					cantidadOcupados += 1;
				} else {
					cantidadVacios += 1;
				}
			}

			if (cantidadVacios == 0) {
				llena = true;
			}

			model.setCantidadOcupados(cantidadOcupados);
			model.setCantidadVacios(cantidadVacios);
			model.setLlena(llena);

			BeanUtils.copyProperties(entity, model);
		} catch (Exception e) {
			throw new WebException("Error al convertir la entidad " + entity.toString() + " a modelo");
		}
		return model;
	}

	public List<Funcion> modelsToEntities(List<FuncionModel> models) throws WebException {
		List<Funcion> entities = new ArrayList<>();
		for (FuncionModel model : models) {
			entities.add(modelToEntity(model));
		}
		return entities;
	}

	public List<FuncionModel> entitiesToModels(List<Funcion> entities) throws WebException {
		List<FuncionModel> models = new ArrayList<>();
		for (Funcion entity : entities) {
			models.add(entityToModel(entity));
		}
		return models;
	}

}

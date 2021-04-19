package com.QuintoTrainee.CineCinco.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuintoTrainee.CineCinco.models.PeliculaModel;
import com.QuintoTrainee.CineCinco.repositories.PeliculaRepository;
import com.QuintoTrainee.CineCinco.converters.PeliculaConverter;
import com.QuintoTrainee.CineCinco.entities.Pelicula;
import com.QuintoTrainee.CineCinco.enums.Genero;
import com.QuintoTrainee.CineCinco.exceptions.WebException;
//import org.apache.commons.lang3.EnumUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	private PeliculaConverter peliculaConverter;
	
	public void hardDelete(PeliculaModel model) {
		Pelicula pelicula = peliculaRepository.getOne(model.getId());
		peliculaRepository.delete(pelicula);
	}
	
	public Pelicula softDelete(PeliculaModel model) {
		Pelicula pelicula = peliculaRepository.getOne(model.getId());
		pelicula.setBaja(new Date());
		return peliculaRepository.save(pelicula);
	}
	
	public Pelicula guardar(PeliculaModel model) throws WebException {
		
		validar(model);
		
		Pelicula entity = peliculaConverter.modelToEntity(model);
		
		if(entity.getAlta() != null) {
			entity.setModificacion(new Date());
		}else {
			entity.setAlta(new Date());
		}
		
		return peliculaRepository.save(entity);
	}     
	
	public void validar(PeliculaModel peliculaM) throws WebException {
		
		if (peliculaM.getTitulo() == null || peliculaM.getTitulo().isEmpty() || peliculaM.getTitulo().equals("")) {
			throw new WebException("La pelicula debe tener un titulo");
		}
		
		if (peliculaM.getSinopsis() == null || peliculaM.getSinopsis().isEmpty() || peliculaM.getSinopsis().equals("")) {
			throw new WebException("La pelicula debe tener una sinopsis");
		}
		
		if (peliculaM.getSinopsis().length() > 4000) {
			throw new WebException("La sinopsis de la pelicula debe ser menor de 4000 caracteres");
		}
		
		if (peliculaM.getGenero() == null) {
			throw new WebException("La pelicula debe tener un genero");
		}
		
		Pelicula peliculaE = peliculaRepository.buscarPorTitulo(peliculaM.getTitulo());
		
		if (peliculaE != null && !peliculaE.getId().equals(peliculaM.getId())) {
			throw new WebException("Ya existe una pelicula con ese titulo");
		}
		
		try {
			Enum.valueOf(Genero.class, peliculaM.getGenero().toString());
		} catch (IllegalArgumentException e) {
			throw new WebException("El genero indicado no es un genero valido");
		} catch (NullPointerException e) {
			throw new WebException("La pelicula debe contener un genero");
		}
		
	}     
	
	
}

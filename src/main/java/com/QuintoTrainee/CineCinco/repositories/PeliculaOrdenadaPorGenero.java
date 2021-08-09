package com.QuintoTrainee.CineCinco.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.QuintoTrainee.CineCinco.entities.Pelicula;
import com.QuintoTrainee.CineCinco.enums.Genero;

@Repository
public class PeliculaOrdenadaPorGenero {
	
	@PersistenceContext
    private EntityManager entityManager;

    public List<Pelicula> buscarPorGenero(int limit, Genero genero) {
        return entityManager.createQuery("SELECT c FROM Pelicula c WHERE c.genero LIKE ?1 ORDER BY alta DESC",
          Pelicula.class).setParameter(1, genero).setMaxResults(limit).getResultList();
        
      
    }
	
	

}

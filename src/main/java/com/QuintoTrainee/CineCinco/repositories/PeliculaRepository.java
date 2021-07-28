package com.QuintoTrainee.CineCinco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.QuintoTrainee.CineCinco.entities.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String>{

	@Query("SELECT p from Pelicula p WHERE p.titulo LIKE :titulo")
	public Pelicula buscarPorTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT p from Pelicula p WHERE p.baja IS NULL")
	public List<Pelicula> listarPeliculasActivas();
	
	@Query( value="SELECT * FROM Pelicula  WHERE baja IS NULL ORDER BY alta DESC LIMIT 4" , nativeQuery=true)
	public List<Pelicula> listarEstrenos ();
	
}

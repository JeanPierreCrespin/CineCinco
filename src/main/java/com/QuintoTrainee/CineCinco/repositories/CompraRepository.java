package com.QuintoTrainee.CineCinco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuintoTrainee.CineCinco.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String>{

}

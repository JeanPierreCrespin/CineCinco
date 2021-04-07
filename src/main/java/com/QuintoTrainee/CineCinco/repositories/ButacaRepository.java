package com.QuintoTrainee.CineCinco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuintoTrainee.CineCinco.entities.Butaca;

@Repository
public interface ButacaRepository extends JpaRepository<Butaca, String>{

}

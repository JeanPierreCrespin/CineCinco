package com.QuintoTrainee.CineCinco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.QuintoTrainee.CineCinco.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	@Query("SELECT c FROM Usuario c WHERE c.mail =:mail")
    public Usuario buscarPorMail(@Param("mail") String mail);

}

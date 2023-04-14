package com.pelicula.service.repositorio;

import java.util.List;

import com.pelicula.service.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

	List<Pelicula> findByPersonaId(Long usuarioId);
	
}

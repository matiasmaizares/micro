package com.pelicula.service.servicios;

import java.util.List;
import java.util.Optional;

import com.pelicula.service.entidades.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelicula.service.repositorio.PeliculaRepository;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;
	public Optional<Pelicula> findById(Long id){
		return peliculaRepository.findById(id);
	}

	public Pelicula save(Pelicula carro) {
		return peliculaRepository.save(carro);
	}
	
	public List<Pelicula> byPersonaId(Long personaId){
		return peliculaRepository.findByPersonaId(personaId);
	}

	public void delete(Long id){
		peliculaRepository.deleteById(id);
	}
}

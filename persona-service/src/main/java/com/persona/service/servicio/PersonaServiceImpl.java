package com.persona.service.servicio;

import java.util.List;
import java.util.Optional;

import com.persona.service.feignclients.PeliculaFeignClient;
import com.persona.service.modelos.Pelicula;
import com.persona.service.servicio.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.persona.service.entidades.Persona;
import com.persona.service.repositorio.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private PeliculaFeignClient peliculaFeignClient;


	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll(Sort.by("lastName").ascending().and(Sort.by("firstName")).ascending()) ;
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}

	@Override
	public Optional<Persona> findByFirstName(String firstName) {
		return personaRepository.findByFirstName(firstName);
	}

	@Override
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void update(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public void delete(Long id) {
		personaRepository.deleteById(id);
	}
	@Override
	public List<Pelicula> getPeliculas(Long personaId) {
		return restTemplate.getForObject("http://localhost:8002/pelicula/persona/" + personaId, List.class);
	}

}
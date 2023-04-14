package com.persona.service.servicio.impl;

import com.persona.service.entidades.Persona;
import com.persona.service.modelos.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<Persona> findAll();
    public Optional<Persona> findById(Long id);
    public Optional<Persona> findByFirstName(String firstName);
    public Persona save(Persona persona);
    public void update(Persona persona);
    public void delete(Long id);
    public List<Pelicula> getPeliculas(Long personaId);
}

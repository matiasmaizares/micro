package com.persona.service.feignclients;

import java.util.List;

import com.persona.service.modelos.Pelicula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "pelicula-service",url = "http://localhost:8002",path = "/pelicula")
public interface PeliculaFeignClient {
	@GetMapping("/persona/{personaId}")
	public List<Pelicula> getPeliculas(@PathVariable("personaId") int personaId);
}

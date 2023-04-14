package com.pelicula.service.controladores;

import com.pelicula.service.entidades.Pelicula;
import com.pelicula.service.servicios.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;

	@PostMapping
	public ResponseEntity<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula){
		return ResponseEntity.ok(peliculaService.save(pelicula));
	}
	
	@GetMapping("/persona/{personaId}")
	public ResponseEntity<List<Pelicula>> listarPeliculasPorPersonaId(@PathVariable("personaId") Long id){
		List<Pelicula> peliculas = peliculaService.byPersonaId(id);
		if(peliculas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(peliculas);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity eliminarPelicula(@PathVariable Long id){
		Pelicula pelicula = peliculaService.findById(id).orElse(null);
		if(pelicula ==null) {
			return ResponseEntity.noContent().build();
		}
		peliculaService.delete(id);
		return ResponseEntity.ok(pelicula);

	}
}
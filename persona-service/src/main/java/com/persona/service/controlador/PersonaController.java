package com.persona.service.controlador;

import java.util.List;

import com.persona.service.ObjectMapperUtils;
import com.persona.service.entidades.Persona;
import com.persona.service.modelos.Pelicula;
import com.persona.service.modelos.PeliculaDto;
import com.persona.service.modelos.PersonaDto;
import com.persona.service.servicio.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public ResponseEntity<List<Persona>> listarPersonas(){
		List<Persona> personas = personaService.findAll();
		if(personas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(personas);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Persona> obtenerPersona(@PathVariable("id") Long id){
		Persona persona = personaService.findById(id).orElse(null);
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(persona);
	}
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Persona> obtenerPersonaPorNombre(@PathVariable("firstName") String firstName){
		System.out.println("firstName = " + firstName);
		Persona persona = personaService.findByFirstName(firstName).orElse(null);
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(persona);
	}
	@PostMapping
	public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona){
		Persona nuevoPersona = personaService.save(persona);
		return ResponseEntity.ok(nuevoPersona);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id,@RequestBody Persona persona){

		Persona existPerson = personaService.findById(id).get();
		existPerson.setFirstName(persona.getFirstName());
		existPerson.setLastName(persona.getLastName());
		existPerson.setHasInsurance(persona.getHasInsurance());
		existPerson.setBirdthDate(persona.getBirdthDate());

		return ResponseEntity.ok( personaService.save(existPerson));
	}

	
	@GetMapping("/peliculas/{personaId}")
	public ResponseEntity<PersonaDto> listarPeliculas(@PathVariable("personaId") Long id){
		Persona persona = personaService.findById(id).orElse(null);
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		List<Pelicula> peliculas = personaService.getPeliculas(id);
		PersonaDto personaDto = personaToDTO(persona,peliculas);
		return ResponseEntity.ok(personaDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		Persona persona = personaService.findById(id).orElse(null);
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		personaService.delete(id);
		return ResponseEntity.ok(null);
	}
	private PersonaDto personaToDTO(Persona persona, List<Pelicula> peliculas){
		PersonaDto personaDto= new PersonaDto();
		personaDto.setId(persona.getId());
		personaDto.setFirstName(persona.getFirstName());
		personaDto.setLastName(persona.getLastName());
		personaDto.setBirdthDate(persona.getBirdthDate());
		personaDto.setHasInsurance(persona.getHasInsurance());
		List<PeliculaDto> peliculaDtos = ObjectMapperUtils.mapAll(peliculas, PeliculaDto.class);
		personaDto.setPeliculaDtos(peliculaDtos);
		return personaDto;
	}

}
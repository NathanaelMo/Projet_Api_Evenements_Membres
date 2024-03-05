package com.controllers;

import ch.qos.logback.classic.Logger;
import com.dtos.EvenementDto;
import com.dtos.InscriptionDto;
import com.dtos.MembreDto;
import com.services.impl.EvenementServiceImpl;
import com.services.impl.InscriptionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

	private final InscriptionServiceImpl inscriptionService;

	public InscriptionController(InscriptionServiceImpl inscriptionService) {
		this.inscriptionService = inscriptionService;
	}

	/**
	 * <p>Get all Inscriptions in the system</p>
	 * @return List<InscriptionDto>
	 */
	@GetMapping
	public List<InscriptionDto> getInscriptions() {
		return inscriptionService.getAllInscriptions();
	}

	/**
	 * Method to get the Inscription based on the ID of an evenement
	 */
	@GetMapping("/evenements/{id}")
	public List<InscriptionDto> getInscriptionByIdEvenement(@PathVariable Long id){
		return inscriptionService.getInscriptionByIdEvenement(id);
	}

	/**
	 * Method to get the Inscription based on the ID of a membre
	 */
	@GetMapping("/membres/{id}")
	public List<InscriptionDto> getInscriptionByIdMembre(@PathVariable Long id){
		return inscriptionService.getInscriptionByIdMembre(id);
	}

	/**
	 * Create a new Inscription in the system
	 */
	@PostMapping
	public InscriptionDto saveInscription(final @RequestBody InscriptionDto inscriptionDto){
		return inscriptionService.saveInscription(inscriptionDto);
	}


	/**
	 * Modify a new Inscription in the system
	 */
	@PutMapping
	public InscriptionDto modifyEvenement(final @RequestBody InscriptionDto inscriptionDto){
		return inscriptionService.modifyInscription(inscriptionDto);
	}

	/**
	 * Delete a Inscription by it's id
	 */
	@DeleteMapping("/membres/{id}/evenements/{id2}")
	public Boolean deleteInscription(@PathVariable Long id, @PathVariable Long id2){
		return inscriptionService.deleteInscription(id, id2);
	}
	
}

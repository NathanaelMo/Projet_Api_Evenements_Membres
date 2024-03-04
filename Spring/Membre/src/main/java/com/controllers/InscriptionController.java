package com.controllers;

import com.dtos.EvenementDto;
import com.dtos.InscriptionDto;
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
	@GetMapping("/evenements/{id_evenement}")
	public InscriptionDto getInscriptionByEvenementId(@PathVariable Long idEvenement){
		return inscriptionService.getInscriptionByEvenementId(idEvenement);
	}

	/**
	 * Method to get the Inscription based on the ID of a membre
	 */
	@GetMapping("/membres/{id_membre}")
	public InscriptionDto getInscriptionByMembreId(@PathVariable Long idMembre){
		return inscriptionService.getInscriptionByMembreId(idMembre);
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
	@DeleteMapping("/membres/{idMembre}/evenements/{idEvenement}")
	public Boolean deleteInscription(@PathVariable Long idMembre, @PathVariable Long idEvenement){
		return inscriptionService.deleteInscription(idMembre, idEvenement);
	}
	
}

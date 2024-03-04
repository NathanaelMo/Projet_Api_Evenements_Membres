package com.controllers;

import com.dtos.EvenementDto;
import com.services.impl.EvenementServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {

	private final EvenementServiceImpl evenementService;

	public EvenementController(EvenementServiceImpl evenementService) {
		this.evenementService = evenementService;
	}

	/**
	 * <p>Get all Evenements in the system</p>
	 * @return List<EvenementDto>
	 */
	@GetMapping
	public List<EvenementDto> getEvenements() {
		return evenementService.getAllEvenements();
	}

	/**
	 * Method to get the Evenement based on the ID
	 */
	@GetMapping("/{id}")
	public EvenementDto getEvenement(@PathVariable Long id){
		return evenementService.getEvenementById(id);
	}

	/**
	 * Create a new Evenement in the system
	 */
	@PostMapping
	public EvenementDto saveEvenement(final @RequestBody EvenementDto evenementDto){
		return evenementService.saveEvenement(evenementDto);
	}


	/**
	 * Modify a new Evenement in the system
	 */
	@PutMapping
	public EvenementDto modifyEvenement(final @RequestBody EvenementDto evenementDto){
		return evenementService.modifyEvenement(evenementDto);
	}

	/**
	 * Delete a Evenement by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteEvenement(@PathVariable Long id){
		return evenementService.deleteEvenement(id);
	}
	
}

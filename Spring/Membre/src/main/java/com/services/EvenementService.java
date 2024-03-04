package com.services;

import com.dtos.EvenementDto;

import java.util.List;

public interface EvenementService {

    /**
     * Sauve a Evenement
     */
    EvenementDto saveEvenement(EvenementDto evenementDto);

    /**
     * Moàify a Evenement
     */
    EvenementDto modifyEvenement(EvenementDto evenementDto);

    /**
     * Get a Evenement by it's id
     */
    EvenementDto getEvenementById(Long evenementId);


    /**
     * Delete a Evenement by it's id
     */
    boolean deleteEvenement(Long evenementId);

    /**
     * Get all the Evenement
     */
    List<EvenementDto> getAllEvenements();


}

package com.services;

import com.dtos.InscriptionDto;

import java.util.List;

public interface InscriptionService {
    /**
     * Sauve a inscription
     */
    InscriptionDto saveInscription(InscriptionDto inscriptionDto);

    /**
     * Sauve a inscription
     */
    InscriptionDto modifyInscription(InscriptionDto inscriptionDto);

    /**
     * Get a inscription by an evenement id
     */
    InscriptionDto getInscriptionByEvenementId(Long evenementId);

    /**
     * Get a inscription by a membre id
     */
    InscriptionDto getInscriptionByMembreId(Long membreId);

    /**
     * Delete a membre by the membre id and the evenment id
     */
    boolean deleteInscription(Long membreId, Long evenementId);

    /**
     * Get all the inscriptions
     */
    List<InscriptionDto> getAllInscriptions();


}

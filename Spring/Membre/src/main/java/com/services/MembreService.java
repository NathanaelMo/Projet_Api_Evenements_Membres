package com.services;

import com.dtos.InscriptionDto;
import com.dtos.MembreDto;

import java.util.List;

public interface MembreService {
    /**
     * Sauve a membre
     */
    MembreDto saveMembre(MembreDto membreDto);

    /**
     * Sauve a membre
     */
    MembreDto modifyMembre(MembreDto membreDto);

    /**
     * Get a membre by it's id
     */
    MembreDto getMembreById(Long membreId);



    List<InscriptionDto> getInscriptionByMembre(Long membreId);

    /**
     * Get a membre by it's id
     */
    List<MembreDto> getMembreByEvenement(Long evenementId);

    /**
     * Delete a membre by it's id
     */
    boolean deleteMembre(Long membreId);

    /**
     * Get all the membres
     */
    List<MembreDto> getAllMembres();


}

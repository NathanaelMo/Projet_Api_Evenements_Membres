package com.services;

import com.dtos.MembreDto;

import java.util.List;

public interface MembreService {
    /**
     * Sauve a dog
     */
    MembreDto saveMembre(MembreDto membreDto);

    /**
     * Get a dog by it's id
     */
    MembreDto getMembreById(Long membreId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteMembre(Long membreId);

    /**
     * Get all the dogs
     */
    List<MembreDto> getAllMembres();


}

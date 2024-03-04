package com.services.impl;
import com.dtos.MembreDto;
import com.entities.Evenement;
import com.dtos.EvenementDto;
import com.entities.Membre;
import com.repositories.EvenementRepository;
import com.repositories.MembreRepository;
import com.services.EvenementService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("evenementService")
public class EvenementServiceImpl implements EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementServiceImpl(EvenementRepository evenementRepository){
        this.evenementRepository = evenementRepository;
    }

    @Override
    public EvenementDto saveEvenement(EvenementDto evenementDto) {
        // Converts the dto to the membre entity
        Evenement evenement = evenementDtoToEntity(evenementDto);
        // Save the membre entity
        evenement = evenementRepository.save(evenement);
        // Return the new dto
        return evenementEntityToDto(evenement);
    }

    @Override
    public EvenementDto modifyEvenement(EvenementDto evenementDto) {
        // Converts the dto to the evenement entity
        Evenement evenement = evenementDtoToEntity(evenementDto);
        // Save the evenement entity
        evenement = evenementRepository.save(evenement);
        // Return the new dto
        return evenementEntityToDto(evenement);
    }

    @Override
    public EvenementDto getEvenementById(Long evenementId) {
        Evenement evenement = evenementRepository.findById(evenementId).orElseThrow(() -> new EntityNotFoundException("membre not found"));
        return evenementEntityToDto(evenement);
    }

    @Override
    public boolean deleteEvenement(Long evenementId) {
        evenementRepository.deleteById(evenementId);
        return true;
    }

    @Override
    public List<EvenementDto> getAllEvenements() {
        List<EvenementDto> evenementDtos = new ArrayList<>();
        List<Evenement> evenements = evenementRepository.findAll();
        evenements.forEach(membre -> {
            evenementDtos.add(evenementEntityToDto(membre));
        });
        return evenementDtos;
    }

    /**
     * Map evenement dto to evenement entity
     */
    private EvenementDto evenementEntityToDto(Evenement evenement){
        EvenementDto evenementDto = new EvenementDto();
        evenementDto.setIdEvenement(evenement.getIdEvenement());
        evenementDto.setIdLieu(evenement.getIdLieu());
        evenementDto.setNom(evenement.getNom());
        evenementDto.setDate(evenement.getDate());
        evenementDto.setDuree(evenement.getDuree());
        evenementDto.setNbMaxPers(evenement.getNbMaxPers());
        return evenementDto;
    }

    /**
     * Map evenement entity to evenement dto
     */
    private Evenement evenementDtoToEntity(EvenementDto evenementDto){
        Evenement evenement = new Evenement();
        evenement.setIdEvenement(evenementDto.getIdEvenement());
        evenement.setIdLieu(evenementDto.getIdLieu());
        evenement.setNom(evenementDto.getNom());
        evenement.setDate(evenementDto.getDate());
        evenement.setDuree(evenementDto.getDuree());
        evenement.setNbMaxPers(evenementDto.getNbMaxPers());
        return evenement;
    }
}

package com.services.impl;

import com.dtos.InscriptionDto;
import com.dtos.MembreDto;
import com.entities.Inscription;
import com.entities.Membre;
import com.repositories.InscriptionRepository;
import com.services.InscriptionService;
import com.services.MembreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("inscriptionService")
public class InscriptionServiceImpl implements InscriptionService {

	private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository){
        this.inscriptionRepository = inscriptionRepository;
    }


    @Override
    public InscriptionDto saveInscription(InscriptionDto inscriptionDto) {
        // Converts the dto to the inscription entity
        Inscription inscription = inscriptionDtoToEntity(inscriptionDto);
        // Save the inscription entity
        inscription = inscriptionRepository.save(inscription);
        // Return the new dto
        return inscriptionEntityToDto(inscription);
    }

    @Override
    public InscriptionDto modifyInscription(InscriptionDto inscriptionDto) {
        // Converts the dto to the inscription entity
        Inscription inscription = inscriptionDtoToEntity(inscriptionDto);
        // Save the inscription entity
        inscription = inscriptionRepository.save(inscription);
        // Return the new dto
        return inscriptionEntityToDto(inscription);
    }

    @Override
    public InscriptionDto getInscriptionByEvenementId(Long evenementId) {
        Inscription inscription = inscriptionRepository.findByEvenementId(evenementId);
        return inscriptionEntityToDto(inscription);
    }

    @Override
    public InscriptionDto getInscriptionByMembreId(Long membreId) {
        Inscription inscription = inscriptionRepository.findByMembreId(membreId);
        return inscriptionEntityToDto(inscription);
    }

    @Override
    public boolean deleteInscription(Long membreId, Long evenementId) {
        inscriptionRepository.deleteByDoubleId(membreId, evenementId);
        return true;
    }

    @Override
    public List<InscriptionDto> getAllInscriptions() {
        List<InscriptionDto> inscriptionDtos = new ArrayList<>();
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        inscriptions.forEach(inscription -> {
            inscriptionDtos.add(inscriptionEntityToDto(inscription));
        });
        return inscriptionDtos;
    }

    /**
     * Map membre dto to membre entity
     */
    private InscriptionDto inscriptionEntityToDto(Inscription inscription){
        InscriptionDto inscriptionDto = new InscriptionDto();
        inscriptionDto.setIdMembre(inscription.getIdMembre());
        inscriptionDto.setIdEvenement(inscription.getIdEvenement());
        return inscriptionDto;
    }

    /**
     * Map membre entity to membre dto
     */
    private Inscription inscriptionDtoToEntity(InscriptionDto inscriptionDto){
        Inscription inscription = new Inscription();
        inscription.setIdMembre(inscriptionDto.getIdMembre());
        inscription.setIdEvenement(inscriptionDto.getIdEvenement());
        return inscription;
    }

}

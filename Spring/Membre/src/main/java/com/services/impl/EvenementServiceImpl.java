package com.services.impl;
import com.dtos.InscriptionDto;
import com.entities.Evenement;
import com.dtos.EvenementDto;
import com.repositories.EvenementRepository;
import com.services.EvenementService;
import com.services.InscriptionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("evenementService")
public class EvenementServiceImpl implements EvenementService {

    private final EvenementRepository evenementRepository;

    private final InscriptionService inscriptionService;

    public EvenementServiceImpl(EvenementRepository evenementRepository, InscriptionService inscriptionService){
        this.evenementRepository = evenementRepository;
        this.inscriptionService = inscriptionService;
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
    public List<EvenementDto> getEvenementByMembre(Long membreId) {
        List<InscriptionDto> inscriptions = inscriptionService.getInscriptionByIdMembre(membreId);
        List<EvenementDto> evenementDtos = new ArrayList<>();
        inscriptions.forEach(inscription -> {
            evenementDtos.add(this.getEvenementById(inscription.getIdEvenement()));
        });
        return evenementDtos;
    }

    @Override
    public List<InscriptionDto> getInscriptionByEvenement(Long idEvenement) {
        return inscriptionService.getInscriptionByIdEvenement(idEvenement);
    }

    @Override
    public InscriptionDto saveInscription(Long id, Long id2) {
        InscriptionDto inscription = new InscriptionDto();
        inscription.setIdEvenement(id);
        inscription.setIdMembre(id2);
        inscriptionService.saveInscription(inscription);
        return inscription;
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

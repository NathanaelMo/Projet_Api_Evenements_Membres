package com.services.impl;

import com.dtos.MembreDto;
import com.dtos.InscriptionDto;
import com.entities.Membre;
import com.repositories.MembreRepository;
import com.services.MembreService;
import com.services.InscriptionService;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("membreService")
public class MembreServiceImpl implements MembreService {

	private final MembreRepository membreRepository;

    private final InscriptionService inscriptionService;

    public MembreServiceImpl(MembreRepository membreRepository, InscriptionService inscriptionService){
        this.membreRepository = membreRepository;
        this.inscriptionService = inscriptionService;
    }

    @Override
    public MembreDto saveMembre(MembreDto membreDto) {
        // Converts the dto to the membre entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the membre entity
        membre = membreRepository.save(membre);
        // Return the new dto
        return membreEntityToDto(membre);
    }

    @Override
    public MembreDto modifyMembre(MembreDto membreDto) {
        // Converts the dto to the membre entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the membre entity
        membre = membreRepository.save(membre);
        // Return the new dto
        return membreEntityToDto(membre);
    }

    @Override
    public MembreDto getMembreById(Long membreId) {
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new EntityNotFoundException("membre not found"));
        return membreEntityToDto(membre);
    }

    @Override
    public List<InscriptionDto> getInscriptionByMembre(Long membreId) {
        return inscriptionService.getInscriptionByIdMembre(membreId);
    }

    @Override
    public List<MembreDto> getMembreByEvenement(Long evenementId) {
        List<InscriptionDto> inscriptions = inscriptionService.getInscriptionByIdEvenement(evenementId);
        List<MembreDto> membreDtos = new ArrayList<>();
        inscriptions.forEach(inscription -> {
            membreDtos.add(this.getMembreById(inscription.getIdMembre()));
        });
        return membreDtos;
    }

    @Override
    public boolean deleteMembre(Long membreId) {
        membreRepository.deleteById(membreId);
        return true;
    }

    @Override
    public List<MembreDto> getAllMembres() {
        List<MembreDto> membreDtos = new ArrayList<>();
        List<Membre> membres = membreRepository.findAll();
        membres.forEach(membre -> {
            membreDtos.add(membreEntityToDto(membre));
        });
        return membreDtos;
    }

    /**
     * Map membre dto to membre entity
     */
    private MembreDto membreEntityToDto(Membre membre){
        MembreDto membreDto = new MembreDto();
        membreDto.setIdMembre(membre.getIdMembre());
        membreDto.setEmail(membre.getEmail());
        membreDto.setNom(membre.getNom());
        membreDto.setPrenom(membre.getPrenom());
        membreDto.setAdresse(membre.getAdresse());
        membreDto.setDateNaissance(membre.getDateNaissance());
        membreDto.setMdp(membre.getMdp());
        return membreDto;
    }

    /**
     * Map membre entity to membre dto
     */
    private Membre membreDtoToEntity(MembreDto membreDto){
        Membre membre = new Membre();
        membre.setIdMembre(membreDto.getIdMembre());
        membre.setEmail(membreDto.getEmail());
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setAdresse(membreDto.getAdresse());
        membre.setDateNaissance(membreDto.getDateNaissance());
        membre.setMdp(membreDto.getMdp());
        return membre;
    }
}

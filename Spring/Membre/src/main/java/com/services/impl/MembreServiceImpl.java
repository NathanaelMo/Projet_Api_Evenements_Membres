package com.services.impl;

import com.dtos.MembreDto;
import com.entities.Membre;
import com.repositories.MembreRepository;
import com.services.MembreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("membreService")
public class MembreServiceImpl implements MembreService {

	private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository){
        this.membreRepository = membreRepository;
    }

    @Override
    public MembreDto saveMembre(MembreDto membreDto) {
        // Converts the dto to the dog entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the dog entity
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
     * Map dog dto to dog entity
     */
    private MembreDto membreEntityToDto(Membre membre){
        MembreDto membreDto = new MembreDto();
        membreDto.setId(membre.getId());
        membreDto.setName(membre.getName());
        membreDto.setRace(membre.getRace());
        return membreDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Membre membreDtoToEntity(MembreDto membreDto){
        Membre membre = new Membre();
        membre.setName(membreDto.getName());
        membre.setId(membreDto.getId());
        membre.setRace(membreDto.getRace());
        return membre;
    }
}

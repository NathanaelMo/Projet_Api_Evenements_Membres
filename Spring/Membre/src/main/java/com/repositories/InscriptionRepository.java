package com.repositories;

import com.dtos.InscriptionDto;
import com.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    void deleteByIdMembreAndIdEvenement(Long idMembre, Long idEvenement);

    Inscription findByIdEvenement(Long idEvenement);


}

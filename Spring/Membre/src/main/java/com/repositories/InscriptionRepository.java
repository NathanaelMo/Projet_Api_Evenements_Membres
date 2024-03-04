package com.repositories;

import com.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    void deleteByDoubleId(Long membreId, Long evenementId);

    Inscription findByEvenementId(Long evenementId);


    Inscription findByMembreId(Long membreId);
}

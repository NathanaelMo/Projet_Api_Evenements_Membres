package com.entities;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Membre {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembre;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String mdp;
	private LocalDate dateNaissance;
}

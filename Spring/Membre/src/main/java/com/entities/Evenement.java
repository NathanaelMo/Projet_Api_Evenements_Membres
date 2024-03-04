package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Evenement {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvenement;

	private int idLieu;

	private String nom;

	private LocalDate date;

	private int duree;

	private int nbMaxPers;


}

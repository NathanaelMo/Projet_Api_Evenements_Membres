package com.entities;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Inscription {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;

	private Long idMembre;

	private Long idEvenement;


}

package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Inscription {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembre;
	@Id
	private Long idEvenement;


}

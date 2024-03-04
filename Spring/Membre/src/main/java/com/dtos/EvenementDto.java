package com.dtos;

import lombok.Data;

import java.time.LocalDate;


@Data
public class EvenementDto {

	private int idEvenement;

	private int idLieu;

	private String nom;

	private LocalDate date;

	private int duree;

	private int nbMaxPers;



}

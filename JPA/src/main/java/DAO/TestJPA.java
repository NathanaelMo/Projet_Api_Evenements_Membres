package DAO;

import Entity.*;

import jakarta.persistence.*;

public class TestJPA {

  public static void main(String[] argv) throws Exception {

    // charge le gestionnaire d'entités lié à l'unité de persistance "SportsPU"
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Association");
    EntityManager em = emf.createEntityManager();
    System.out.println("PU chargée");

    // récupère le sport d'identifiant 1, affiche son intitulé et ses disciplines
    int cle = 1;
    MembreEntity membre = em.find(MembreEntity.class, cle);
    System.out.println("Le sport " + cle + " est " + membre.getPrenom());

  }
}

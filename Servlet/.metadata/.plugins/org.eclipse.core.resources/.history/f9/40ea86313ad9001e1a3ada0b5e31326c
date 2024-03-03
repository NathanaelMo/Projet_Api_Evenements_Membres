package DAO;

import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax

public class DAO_JPA<D> extends DAO {

  /**
   * entitymanagerfactory crée dans la constructeur
   * à mettre à jour si c'est récupérable autre part
   */
  private EntityManagerFactory emf;

  /**
   * same
   */
  private EntityManager em;

  /**
   * Utilisé pour set la classe du DAO
   */
  private Class<D> clas;

  /**
   * Construit le DAO pour la classe param�tr�e.
   *
   * @throws DAOException en cas de probl�me
   */
  public DAO_JPA() throws DAOException {
    try {
      // charge le gestionnaire d'entités lié à l'unité de persistance "SportsPU"
      this.emf = Persistence.createEntityManagerFactory("SportsPU");
      this.em = emf.createEntityManager();
    }catch(Exception e){
      throw new DAOException("Problème technique (" + e.getMessage() + ")");
    }
  }

  /**
   * Méthode utilisé pour désigner la classe du DAO à gérer
   * @param classToSet
   */
  public final void setClass( Class<D> classToSet ){
    this.clas = classToSet;
  }

  @Override
  public Object find(int id) throws DAOException {

    // récupère le class d'identifiant id
    return this.em.find(this.clas, id);
  }

  @Override
  public void create(Object data) throws DAOException {
    this.em.persist(data);
  }

  @Override
  public void update(Object data) throws DAOException {
    this.em.merge(data);
  }

  @Override
  public void delete(Object data) throws DAOException {
    this.em.remove(data);
  }
}

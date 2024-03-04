package DAO;

import Entity.*;

public class DAOFactory {
  /**
   * Le DAO concret en JPA pour la table Evenement
   */
  private DAO_JPA<EvenementEntity> daoEvenement= null;

  /**
   * Le DAO concret en JPA pour la table Lieu
   */
  private DAO_JPA<LieuEntity> daoLieu = null;

  /**
   * Le DAO concret en JPA pour la table Membre
   */
  private DAO_JPA<MembreEntity> daoMembre = null;


  public DAO<MembreEntity> getDAOMembre() throws DAOException {
    if ( this.daoMembre==null) {
      this.daoMembre = new DAO_JPA<MembreEntity>();
      this.daoMembre.setClass(MembreEntity.class);
    }
    return this.daoMembre;
  }


  public DAO<LieuEntity> getDAOLieu() throws DAOException {
    if ( this.daoLieu==null) {
      this.daoLieu = new DAO_JPA<LieuEntity>();
      this.daoLieu.setClass( LieuEntity.class);
    }
    return this.daoLieu;
  }

  public DAO<EvenementEntity> getDAOEvenement() throws DAOException {
    if ( this.daoEvenement==null) {
      this.daoEvenement = new DAO_JPA<EvenementEntity>();
      this.daoEvenement.setClass( EvenementEntity.class);
    }
    return this.daoEvenement;
  }
}

package DAO;

import donnees.Discipline;
import donnees.Sport;
import donnees.Sportif;
import sportsDAO.*;

public class Sports_JPA_DAOFactory extends SportsDAOFactory {
  /**
   * Le DAO concret en JDBC pour la table Sport
   */
  private DAO_JPA<Sport> daoSport = null;

  /**
   * Le DAO concret en JDBC pour la table Discipline
   */
  private DAO_JPA<Discipline> daoDiscipline = null;

  /**
   * Le DAO concret en JDBC pour la table Sportif
   */
  private DAO_JPA<Sportif> daoSportif = null;
  @Override
  public DAO<Sport> getDAOSport() throws DAOException {
    if ( this.daoSport==null) {
      this.daoSport = new DAO_JPA<Sport>();
      this.daoSport.setClass(Sport.class);
    }
    return this.daoSport;
  }

  @Override
  public DAO<Discipline> getDAODiscipline() throws DAOException {
    if ( this.daoDiscipline==null) {
      this.daoDiscipline = new DAO_JPA<Discipline>();
      this.daoDiscipline.setClass(Discipline.class);
    }
    return this.daoDiscipline;
  }

  public DAO<Sportif> getDAOSportif() throws DAOException {
    if ( this.daoSportif==null) {
      this.daoSportif = new DAO_JPA<Sportif>();
      this.daoSportif.setClass(Sportif.class);
    }
    return this.daoSportif;
  }
}

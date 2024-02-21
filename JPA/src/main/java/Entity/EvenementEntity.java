package Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "evenement", schema = "e21905149_db1")
public class EvenementEntity {
  @Basic
  @Column(name = "id_lieu", nullable = false)
  private int idLieu;
  @Basic
  @Column(name = "nom", nullable = false, length = 200)
  private String nom;
  @Basic
  @Column(name = "date", nullable = false)
  private Date date;
  @Basic
  @Column(name = "duree", nullable = false)
  private int duree;
  @Basic
  @Column(name = "nb_max_pers", nullable = false)
  private int nbMaxPers;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_evenement", nullable = false)
  private int idEvenement;

  public int getIdLieu() {
    return idLieu;
  }

  public void setIdLieu(int idLieu) {
    this.idLieu = idLieu;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getDuree() {
    return duree;
  }

  public void setDuree(int duree) {
    this.duree = duree;
  }

  public int getNbMaxPers() {
    return nbMaxPers;
  }

  public void setNbMaxPers(int nbMaxPers) {
    this.nbMaxPers = nbMaxPers;
  }

  public int getIdEvenement() {
    return idEvenement;
  }

  public void setIdEvenement(int idEvenement) {
    this.idEvenement = idEvenement;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    EvenementEntity that = (EvenementEntity) o;

    if (idLieu != that.idLieu) return false;
    if (duree != that.duree) return false;
    if (nbMaxPers != that.nbMaxPers) return false;
    if (idEvenement != that.idEvenement) return false;
    if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
    if (date != null ? !date.equals(that.date) : that.date != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = idLieu;
    result = 31 * result + (nom != null ? nom.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + duree;
    result = 31 * result + nbMaxPers;
    result = 31 * result + idEvenement;
    return result;
  }
}

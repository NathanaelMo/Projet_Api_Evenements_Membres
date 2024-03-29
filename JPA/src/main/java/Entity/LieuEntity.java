package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lieu", schema = "e21905149_db1")
@NamedQueries({
    @NamedQuery(name = "Lieu.findAll", query = "SELECT l FROM LieuEntity l"),
    @NamedQuery(name = "Lieu.findByIdLieu", query = "SELECT l FROM LieuEntity l WHERE l.idLieu = :idLieu"),
    @NamedQuery(name = "Inscription.findByEvenement", query = "SELECT d FROM InscriptionEntity d WHERE d.idEvenement = :idEvenement")})
public class LieuEntity {
  @Basic
  @Column(name = "nom", nullable = false, length = 200)
  private String nom;
  @Basic
  @Column(name = "adresse", nullable = false, length = 200)
  private String adresse;
  @Basic
  @Column(name = "nb_max_pers", nullable = false)
  private int nbMaxPers;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_lieu", nullable = false)
  private int idLieu;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public int getNbMaxPers() {
    return nbMaxPers;
  }

  public void setNbMaxPers(int nbMaxPers) {
    this.nbMaxPers = nbMaxPers;
  }

  public int getIdLieu() {
    return idLieu;
  }

  public void setIdLieu(int idLieu) {
    this.idLieu = idLieu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LieuEntity that = (LieuEntity) o;

    if (nbMaxPers != that.nbMaxPers) return false;
    if (idLieu != that.idLieu) return false;
    if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
    if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = nom != null ? nom.hashCode() : 0;
    result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
    result = 31 * result + nbMaxPers;
    result = 31 * result + idLieu;
    return result;
  }
}

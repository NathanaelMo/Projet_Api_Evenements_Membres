package Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "membre", schema = "e21905149_db1")
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM MembreEntity m"),
    @NamedQuery(name = "Membre.findByIdMembre", query = "SELECT m FROM MembreEntity m WHERE m.idMembre = :idMembre"),
})
public class MembreEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_membre", nullable = false)
  private int idMembre;
  @Basic
  @Column(name = "email", nullable = false, length = 200)
  private String email;
  @Basic
  @Column(name = "nom", nullable = false, length = 200)
  private String nom;
  @Basic
  @Column(name = "prenom", nullable = false, length = 200)
  private String prenom;
  @Basic
  @Column(name = "date_naissance", nullable = false)
  private Date dateNaissance;
  @Basic
  @Column(name = "mdp", nullable = false, length = 200)
  private String mdp;
  @Basic
  @Column(name = "adresse", nullable = false, length = 200)
  private String adresse;

  public int getIdMembre() {
    return idMembre;
  }

  public void setIdMembre(int idMembre) {
    this.idMembre = idMembre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getMdp() {
    return mdp;
  }

  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MembreEntity that = (MembreEntity) o;

    if (idMembre != that.idMembre) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
    if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
    if (dateNaissance != null ? !dateNaissance.equals(that.dateNaissance) : that.dateNaissance != null) return false;
    if (mdp != null ? !mdp.equals(that.mdp) : that.mdp != null) return false;
    if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = idMembre;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (nom != null ? nom.hashCode() : 0);
    result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
    result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
    result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
    result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
    return result;
  }
}

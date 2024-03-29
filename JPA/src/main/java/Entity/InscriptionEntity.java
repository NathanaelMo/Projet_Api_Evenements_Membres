package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inscription", schema = "e21905149_db1")
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT d FROM InscriptionEntity d"),
    @NamedQuery(name = "Inscription.findByMembre", query = "SELECT d FROM InscriptionEntity d WHERE d.idMembre = :idMembre"),
    @NamedQuery(name = "Inscription.findByEvenement", query = "SELECT d FROM InscriptionEntity d WHERE d.idEvenement = :idEvenement")})
public class InscriptionEntity {
  @Id
  @Column(name = "id_membre", nullable = false)
  private int idMembre;
  @Id
  @Column(name = "id_evenement", nullable = false)
  private int idEvenement;


  public int getIdMembre() {
    return idMembre;
  }

  public void setIdMembre(int idMembre) {
    this.idMembre = idMembre;
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

    InscriptionEntity that = (InscriptionEntity) o;

    if (idMembre != that.idMembre) return false;
    if (idEvenement != that.idEvenement) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = idMembre;
    result = 31 * result + idEvenement;
    return result;
  }

}

package Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscription", schema = "e21905149_db1", catalog = "")
public class InscriptionEntity {
  @Basic
  @Column(name = "id_membre", nullable = false)
  private int idMembre;
  @Basic
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

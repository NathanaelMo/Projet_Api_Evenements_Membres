package donnees;

import javax.persistence.*;

@Entity
@Table(name = "inscription", schema = "e21905149_db1")
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT d FROM InscriptionEntity d"),
    @NamedQuery(name = "Inscription.findByMembre", query = "SELECT d FROM InscriptionEntity d WHERE d.primaryKey.idMembre = :idMembre"),
    @NamedQuery(name = "Inscription.findByEvenement", query = "SELECT d FROM InscriptionEntity d WHERE d.primaryKey.idEvenement = :idEvenement")})
public class InscriptionEntity {
  
  @EmbeddedId
  private InscriptionEntityPrimaryKey primaryKey;

  public int getIdMembre() {
    return this.primaryKey.getIdMembre();
  }

  public void setIdMembre(int idMembre) {
    this.primaryKey.setIdMembre(idMembre);
  }

  public int getIdEvenement() {
    return this.primaryKey.getIdEvenement();
  }

  public void setIdEvenement(int idEvenement) {
    this.primaryKey.setIdEvenement(idEvenement);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    InscriptionEntity that = (InscriptionEntity) o;

    if (this.primaryKey.getIdMembre()!= that.primaryKey.getIdMembre()) return false;
    if (this.primaryKey.getIdEvenement() != that.primaryKey.getIdEvenement()) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = this.primaryKey.getIdMembre();
    result = 31 * result + this.primaryKey.getIdEvenement();
    return result;
  }

}

package donnees;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class InscriptionEntityPrimaryKey implements Serializable {
    private int idMembre;
    private int idEvenement;

    // Constructeur par défaut (obligatoire pour JPA)
    public InscriptionEntityPrimaryKey() {
    }

    // Constructeur avec les deux id
    public InscriptionEntityPrimaryKey(int idMembre, int idEvenement) {
        this.idMembre = idMembre;
        this.idEvenement = idEvenement;
    }

    // Getters et Setters

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

    // Equals et HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntityPrimaryKey that = (InscriptionEntityPrimaryKey) o;

        return idMembre == that.idMembre && idEvenement == that.idEvenement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembre, idEvenement);
    }
}
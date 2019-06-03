package ro.pata.jpa.eni.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonneAdresseEntityPK implements Serializable {
    private int idAdresse;
    private int idPersonne;

    @Column(name = "id_adresse", nullable = false)
    @Id
    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Column(name = "id_personne", nullable = false)
    @Id
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneAdresseEntityPK that = (PersonneAdresseEntityPK) o;
        return idAdresse == that.idAdresse &&
                idPersonne == that.idPersonne;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresse, idPersonne);
    }
}

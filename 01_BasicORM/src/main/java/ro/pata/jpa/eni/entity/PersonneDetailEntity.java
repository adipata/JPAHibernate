package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personne_detail", schema = "bdd_eni")
public class PersonneDetailEntity {
    private int idPersonne;
    private String sexe;
    private String numSecu;
    private PersonneEntity personne;

    @Id
    @Column(name = "id_personne", nullable = false)
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "sexe", nullable = true, length = 1)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Basic
    @Column(name = "num_secu", nullable = true, length = 255)
    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    @OneToOne
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    public PersonneEntity getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneEntity personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "PersonneDetailEntity{" +
                "idPersonne=" + idPersonne +
                ", sexe='" + sexe + '\'' +
                ", numSecu='" + numSecu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneDetailEntity that = (PersonneDetailEntity) o;
        return idPersonne == that.idPersonne &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(numSecu, that.numSecu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, sexe, numSecu);
    }
}

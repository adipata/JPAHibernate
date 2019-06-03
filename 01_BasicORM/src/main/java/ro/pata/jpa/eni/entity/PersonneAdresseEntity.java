package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "personne_adresse", schema = "bdd_eni", catalog = "")
@IdClass(PersonneAdresseEntityPK.class)
public class PersonneAdresseEntity {
    private int idAdresse;
    private int idPersonne;
    private byte principale;
    private Date debut;
    private Date fin;

    @Id
    @Column(name = "id_adresse", nullable = false)
    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Id
    @Column(name = "id_personne", nullable = false)
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "principale", nullable = false)
    public byte getPrincipale() {
        return principale;
    }

    public void setPrincipale(byte principale) {
        this.principale = principale;
    }

    @Basic
    @Column(name = "debut", nullable = false)
    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    @Basic
    @Column(name = "fin", nullable = true)
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneAdresseEntity that = (PersonneAdresseEntity) o;
        return idAdresse == that.idAdresse &&
                idPersonne == that.idPersonne &&
                principale == that.principale &&
                Objects.equals(debut, that.debut) &&
                Objects.equals(fin, that.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresse, idPersonne, principale, debut, fin);
    }
}

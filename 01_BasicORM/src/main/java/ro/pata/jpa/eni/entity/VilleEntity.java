package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ville", schema = "bdd_eni", catalog = "")
public class VilleEntity {
    private int id;
    private byte capital;
    private String codePostal;
    private String nom;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "capital", nullable = false)
    public byte getCapital() {
        return capital;
    }

    public void setCapital(byte capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "code_postal", nullable = true, length = 255)
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VilleEntity that = (VilleEntity) o;
        return id == that.id &&
                capital == that.capital &&
                Objects.equals(codePostal, that.codePostal) &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capital, codePostal, nom);
    }
}

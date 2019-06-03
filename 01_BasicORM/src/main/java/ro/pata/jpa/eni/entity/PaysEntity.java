package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays", schema = "bdd_eni", catalog = "")
public class PaysEntity {
    private int id;
    private String monnai;
    private String nom;
    private Long population;
    private String continent;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "monnai", nullable = false, length = 255)
    public String getMonnai() {
        return monnai;
    }

    public void setMonnai(String monnai) {
        this.monnai = monnai;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "population", nullable = true)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Basic
    @Column(name = "continent", nullable = true, length = 45)
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysEntity that = (PaysEntity) o;
        return id == that.id &&
                Objects.equals(monnai, that.monnai) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(population, that.population) &&
                Objects.equals(continent, that.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monnai, nom, population, continent);
    }
}

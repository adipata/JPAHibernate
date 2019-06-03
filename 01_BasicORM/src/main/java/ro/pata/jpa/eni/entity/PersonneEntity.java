package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "personne", schema = "bdd_eni")
public class PersonneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "date_naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;

    @Basic
    @Column(name = "nom")
    private String nom;

    @Basic
    @Column(name = "prenom")
    private String prenom;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneEntity that = (PersonneEntity) o;
        return id == that.id &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateNaissance, nom, prenom);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return "PersonneEntity{" +
                "dateNaissance=" + format.format(dateNaissance) +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id=" + id +
                '}';
    }
}

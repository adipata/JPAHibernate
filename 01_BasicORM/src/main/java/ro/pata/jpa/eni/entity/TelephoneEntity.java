package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "telephone", schema = "bdd_eni", catalog = "")
public class TelephoneEntity {
    private int id;
    private String libelle;
    private String numero;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle", nullable = true, length = 255)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "numero", nullable = false, length = 255)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneEntity that = (TelephoneEntity) o;
        return id == that.id &&
                Objects.equals(libelle, that.libelle) &&
                Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, numero);
    }
}

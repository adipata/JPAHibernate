package ro.pata.jpa.eni.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_langue", schema = "bdd_eni", catalog = "")
@IdClass(PaysLangueEntityPK.class)
public class PaysLangueEntity {
    private int idLangue;
    private int idPays;

    @Id
    @Column(name = "id_langue", nullable = false)
    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }

    @Id
    @Column(name = "id_pays", nullable = false)
    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysLangueEntity that = (PaysLangueEntity) o;
        return idLangue == that.idLangue &&
                idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLangue, idPays);
    }
}

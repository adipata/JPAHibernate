package ro.pata.jpa.eni.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PaysLangueEntityPK implements Serializable {
    private int idLangue;
    private int idPays;

    @Column(name = "id_langue", nullable = false)
    @Id
    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }

    @Column(name = "id_pays", nullable = false)
    @Id
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
        PaysLangueEntityPK that = (PaysLangueEntityPK) o;
        return idLangue == that.idLangue &&
                idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLangue, idPays);
    }
}

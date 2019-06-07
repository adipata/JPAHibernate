package ro.pata.jpa.eni.entity_test;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agenda_detail", schema = "adi", catalog = "")
public class AgendaDetailEntity {
    private int id;
    private Integer idAgenda;
    private String address;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_agenda", nullable = true)
    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaDetailEntity that = (AgendaDetailEntity) o;
        return id == that.id &&
                Objects.equals(idAgenda, that.idAgenda) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAgenda, address);
    }
}

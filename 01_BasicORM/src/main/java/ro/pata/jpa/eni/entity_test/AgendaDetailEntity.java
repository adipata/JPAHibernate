package ro.pata.jpa.eni.entity_test;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agenda_detail", schema = "adi")
public class AgendaDetailEntity {
    private int id;
    private String address;
    private AgendaEntity agenda;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToOne
    @JoinColumn(name = "id_agenda")
    public AgendaEntity getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaEntity agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "AgendaDetailEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaDetailEntity that = (AgendaDetailEntity) o;
        return id == that.id &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }
}

package ro.pata.jpa.eni.entity_test;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "telefon", schema = "adi")
@TableGenerator(name = "GenTelefon", allocationSize = 1)
public class TelefonEntity {
    private int id;
    private AgendaEntity agenda;
    private String telefon;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "GenTelefon")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_agenda",referencedColumnName = "id")
    public AgendaEntity getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaEntity agenda) {
        this.agenda = agenda;
    }

    @Basic
    @Column(name = "telefon", nullable = true, length = 50)
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonEntity that = (TelefonEntity) o;
        return id == that.id &&
                Objects.equals(agenda, that.agenda) &&
                Objects.equals(telefon, that.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agenda, telefon);
    }
}

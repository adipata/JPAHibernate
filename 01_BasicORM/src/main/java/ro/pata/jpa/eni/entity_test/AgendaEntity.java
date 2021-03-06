package ro.pata.jpa.eni.entity_test;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agenda", schema = "adi")
@SequenceGenerator(name = "seqGen", allocationSize = 1)
public class AgendaEntity {
    private int id;
    private String nume;
    private String telefon;
    private AgendaDetailEntity detail;
    private List<TelefonEntity> telefonList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nume", nullable = true, length = 30)
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "telefon", nullable = true, length = 30)
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @OneToOne(mappedBy = "agenda",cascade = CascadeType.ALL)
    public AgendaDetailEntity getDetail() {
        return detail;
    }

    public void setDetail(AgendaDetailEntity detail) {
        detail.setAgenda(this);
        this.detail = detail;
    }

    @OneToMany(mappedBy = "agenda")
    public List<TelefonEntity> getTelefonList() {
        return telefonList;
    }

    public void setTelefonList(List<TelefonEntity> telefonList) {
        this.telefonList = telefonList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaEntity that = (AgendaEntity) o;
        return id == that.id &&
                Objects.equals(nume, that.nume) &&
                Objects.equals(telefon, that.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, telefon);
    }

    @Override
    public String toString() {
        return "AgendaEntity{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}

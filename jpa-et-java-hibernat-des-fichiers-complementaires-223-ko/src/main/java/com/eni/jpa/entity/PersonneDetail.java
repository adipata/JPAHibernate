/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.entity;

import com.eni.jpa.entity.convertisseur.GenreConvertisseur;
import com.eni.jpa.entity.listener.PersonneDetailListener;
import com.eni.jpa.enumeration.Genre;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author martial
 */
@Entity
@Table(name = "personne_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonneDetail.findAll", query = "SELECT p FROM PersonneDetail p")
    , @NamedQuery(name = "PersonneDetail.findByIdPersonne", query = "SELECT p FROM PersonneDetail p WHERE p.idPersonne = :idPersonne")
    , @NamedQuery(name = "PersonneDetail.findBySexe", query = "SELECT p FROM PersonneDetail p WHERE p.sexe = :sexe")
    , @NamedQuery(name = "PersonneDetail.findByNumSecu", query = "SELECT p FROM PersonneDetail p WHERE p.numSecu = :numSecu")})
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@EntityListeners({PersonneDetailListener.class})
public class PersonneDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Column(name = "sexe")
    @Convert(converter = GenreConvertisseur.class)
    private Genre sexe;
    @Column(name = "num_secu")
    private String numSecu;
    @JoinColumn(name = "id_personne", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public PersonneDetail() {
    }

    public PersonneDetail(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Genre getSexe() {
        return sexe;
    }

    public void setSexe(Genre sexe) {
        this.sexe = sexe;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @PrePersist
    public void avantSauvegarde(){
        System.out.println("entity prepersist");
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonneDetail)) {
            return false;
        }
        PersonneDetail other = (PersonneDetail) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eni.jpa.entity.PersonneDetail[ idPersonne=" + idPersonne + " ]";
    }
    
}

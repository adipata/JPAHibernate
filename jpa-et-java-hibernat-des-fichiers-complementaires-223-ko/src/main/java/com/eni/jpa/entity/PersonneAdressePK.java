/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author martial
 */
@Embeddable
public class PersonneAdressePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_adresse")
    private int idAdresse;
    @Basic(optional = false)
    @Column(name = "id_personne")
    private int idPersonne;

    public PersonneAdressePK() {
    }

    public PersonneAdressePK(int idAdresse, int idPersonne) {
        this.idAdresse = idAdresse;
        this.idPersonne = idPersonne;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAdresse;
        hash += (int) idPersonne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonneAdressePK)) {
            return false;
        }
        PersonneAdressePK other = (PersonneAdressePK) object;
        if (this.idAdresse != other.idAdresse) {
            return false;
        }
        if (this.idPersonne != other.idPersonne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eni.jpa.entity.PersonneAdressePK[ idAdresse=" + idAdresse + ", idPersonne=" + idPersonne + " ]";
    }
    
}

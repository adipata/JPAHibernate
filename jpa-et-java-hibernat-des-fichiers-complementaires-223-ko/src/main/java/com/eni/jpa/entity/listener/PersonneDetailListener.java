/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.entity.listener;

import com.eni.jpa.entity.PersonneDetail;
import javax.persistence.PrePersist;

/**
 *
 * @author martial
 */
public class PersonneDetailListener {
    
    @PrePersist
    public void avantSauvegarde(PersonneDetail p){
        p.setIdPersonne(p.getPersonne().getId());
    }
    
}

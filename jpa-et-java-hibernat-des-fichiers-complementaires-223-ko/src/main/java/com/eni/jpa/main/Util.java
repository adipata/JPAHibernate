/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.main;

import com.eni.jpa.entity.Personne;

/**
 *
 * @author martial
 */
public class Util {

    public static void afficherPersonne(Personne p) {
        System.out.println(p.getId());
        System.out.println(p.getNom());
        System.out.println(p.getPrenom());
        System.out.println(p.getPersonneDetail().getNumSecu());
        System.out.println(p.getPersonneDetail().getSexe());
    }

}

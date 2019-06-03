/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.main;

import com.eni.jpa.controller.netbeans.PersonneDetailJpaController;
import com.eni.jpa.controller.netbeans.PersonneJpaController;
import com.eni.jpa.entity.Personne;
import com.eni.jpa.entity.PersonneDetail;
import com.eni.jpa.enumeration.Genre;
import com.eni.jpa.util.JpaUtil;

/**
 *
 * @author martial
 */
public class LanceurControleurNetBeans {

    public static void main(String[] args) {
        try {
            createPersonne1();
        } finally {
            JpaUtil.close();
        }
    }

    private static void createPersonne1() {
        Personne p = new Personne();
        p.setNom("nom");
        p.setPrenom("prenom");
        p.setPersonneDetail(new PersonneDetail());
        p.getPersonneDetail().setPersonne(p);
        PersonneJpaController ctrl = new PersonneJpaController(JpaUtil.getEmf());
        ctrl.create(p);
    }

    private static Personne createPersonne2() {
        Personne p = new Personne();
        try {
            p.setNom("nom");
            p.setPrenom("prenom");
            PersonneJpaController ctrl = new PersonneJpaController(JpaUtil.getEmf());
            PersonneDetailJpaController ctrlDetail = new PersonneDetailJpaController(JpaUtil.getEmf());
            ctrl.create(p);

            PersonneDetail personneDetail = new PersonneDetail();
            personneDetail.setPersonne(p);
            personneDetail.setSexe(Genre.FEMME);
            ctrlDetail.create(personneDetail);
            p.setPersonneDetail(personneDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    private static void supprimerPersonne1() {
        try {
            Personne p = createPersonne2();

            PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());
            pCtrl.destroy(p.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void supprimerPersonne2() {
        try {
            Personne p = createPersonne2();

            PersonneDetailJpaController detCtrl = new PersonneDetailJpaController(JpaUtil.getEmf());
            detCtrl.destroy(p.getPersonneDetail().getIdPersonne());

            PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());
            pCtrl.destroy(p.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modifierPersonne1() {
        Personne p = createPersonne2();

        PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());

        System.out.println("----------------- Ancienne Personne ---------- ");
        Util.afficherPersonne(p);
        System.out.println("----------------- Ancienne Personne ---------- ");
        p.setNom("nouveauNom");
        p.getPersonneDetail().setNumSecu("numSecu");
        try {
            pCtrl.edit(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Personne newPers = pCtrl.findPersonne(p.getId());
        System.out.println("----------------- Nouvelle Personne ---------- ");
        Util.afficherPersonne(newPers);
        System.out.println("----------------- Nouvelle Personne ---------- ");

        suppPers(p.getId());
    }

    private static void modifierPersonne2() {
        Personne p = createPersonne2();

        PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());
        PersonneDetailJpaController detCtrl = new PersonneDetailJpaController(JpaUtil.getEmf());

        System.out.println("----------------- Ancienne Personne ---------- ");
        Util.afficherPersonne(p);
        System.out.println("----------------- Ancienne Personne ---------- ");
        p.setNom("nouveauNom");
        p.getPersonneDetail().setNumSecu("numSecu");
        try {
            detCtrl.edit(p.getPersonneDetail());
            pCtrl.edit(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Personne newPers = pCtrl.findPersonne(p.getId());
        System.out.println("----------------- Nouvelle Personne ---------- ");
        Util.afficherPersonne(newPers);
        System.out.println("----------------- Nouvelle Personne ---------- ");

        suppPers(p.getId());
    }

    private static void modifierPersonne3() {
        Personne p = createPersonne2();

        PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());
        PersonneDetailJpaController detCtrl = new PersonneDetailJpaController(JpaUtil.getEmf());

        System.out.println("----------------- Ancienne Personne ---------- ");
        Util.afficherPersonne(p);
        System.out.println("----------------- Ancienne Personne ---------- ");
        p.setNom("nouveauNom");
        PersonneDetail det = detCtrl.findPersonneDetail(p.getId());
        det.setNumSecu("numSecu");
        try {
            detCtrl.edit(det);
            pCtrl.edit(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Personne newPers = pCtrl.findPersonne(p.getId());
        System.out.println("----------------- Nouvelle Personne ---------- ");
        Util.afficherPersonne(newPers);
        System.out.println("----------------- Nouvelle Personne ---------- ");

        suppPers(p.getId());
    }

    private static void suppPers(int id) {
        try {
            PersonneDetailJpaController detCtrl = new PersonneDetailJpaController(JpaUtil.getEmf());
            detCtrl.destroy(id);
            PersonneJpaController pCtrl = new PersonneJpaController(JpaUtil.getEmf());
            pCtrl.destroy(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

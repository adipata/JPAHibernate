/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.main;

import com.eni.jpa.controller.modifie.CriteriaQueryControleur;
import com.eni.jpa.controller.modifie.LangueControleur;
import com.eni.jpa.controller.modifie.PaysControleur;
import com.eni.jpa.controller.modifie.PersonneControleur;
import com.eni.jpa.entity.Langue;
import com.eni.jpa.entity.Pays;
import com.eni.jpa.entity.Personne;
import com.eni.jpa.entity.PersonneDetail;
import com.eni.jpa.enumeration.Genre;
import com.eni.jpa.util.JpaUtil;
import java.util.List;

/**
 *
 * @author martial
 */
public class LanceurControleurModif {

    public static void main(String[] args) {
        try {
            rechercherUnPays();

            rechercherUnPays();
        } finally {
            JpaUtil.close();
        }
    }

    private static Personne createPersonne() {
        //Création de Personne
        Personne p = new Personne();
        //Définition des infos de Personne
        p.setNom("nom");
        p.setPrenom("prenom");
        //Création du détail
        PersonneDetail personneDetail = new PersonneDetail();
        //Mise en place de la relation
        p.setPersonneDetail(personneDetail);
        personneDetail.setPersonne(p);
        //Définition des infos de PersonneDetail
        personneDetail.setSexe(Genre.FEMME);

        //Acces au contrôleur pour créer Personne et PersonneDetail
        PersonneControleur ctrl = new PersonneControleur();
        ctrl.create(p);
        return p;
    }

    private static void modifierPersonne() {

        Personne p = createPersonne();

        PersonneControleur pCtrl = new PersonneControleur();

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

        try {
            pCtrl.destroy(p.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void supprimerPersonne() {
        try {
            Personne p = createPersonne();

            PersonneControleur pCtrl = new PersonneControleur();
            pCtrl.destroy(p.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void rechercherPays1() {
        PaysControleur pCtrl = new PaysControleur();
        List<Pays> lstPays = pCtrl.findPaysEntities();
        for (Pays pays : lstPays) {
            System.out.println(pays.getNom());
            System.out.println(pays.getLangueList());
        }
    }

    private static void rechercherPays2() {
        PaysControleur pCtrl = new PaysControleur();
        List<Pays> lstPays = pCtrl.findPaysEntitiesAvecLangue();
        for (Pays pays : lstPays) {
            System.out.println(pays.getNom() + " " + pays.getId());
            System.out.println(pays.getLangueList());
        }
    }

    private static void rechercherUnPays() {
        PaysControleur pCtrl = new PaysControleur();
        Pays pays = pCtrl.findPays(2);
        System.out.println(pays.getNom());
        System.out.println(pays.getLangueList());
    }

    private static void rechercherUnPays1() {
        PaysControleur pCtrl = new PaysControleur();
        Pays pays = pCtrl.findPays(2);
        System.out.println(pays.getNom());
        LangueControleur lCtrl = new LangueControleur();
        System.out.println(lCtrl.findLangueByIdPays(pays));
    }

    private static void rechercherUnPays2() {
        PaysControleur pCtrl = new PaysControleur();
        Pays pays = pCtrl.findPaysAvecLangue(2);
        System.out.println(pays.getNom());
        System.out.println(pays.getLangueList());
    }

    private static void rechercherUnPays3() {
        PaysControleur pCtrl = new PaysControleur();
        Pays pays = pCtrl.findPaysAvecLangue2(2);
        System.out.println(pays.getNom());
        System.out.println(pays.getLangueList());
    }

    private static void rechercherRequeteCriteria() {
        CriteriaQueryControleur cqCtrl = new CriteriaQueryControleur();
        List<Personne> lst = cqCtrl.rechercher("", "p%", null, null, null);

        for (Personne personne : lst) {
            System.out.println(personne);
            System.out.println(personne.getTelephoneList());
        }

    }

}

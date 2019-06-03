/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author martial
 */
public class JpaUtil {
    
    private static EntityManagerFactory emf = null;

    private JpaUtil() {
    }
    
    public static synchronized EntityManagerFactory getEmf() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("PROJET_ENI_MAVEN");
        }
        return emf;
    }
    
    public static synchronized void close(){
        if(emf != null){
            emf.close();
            emf = null;
        }
    }
    
    
}

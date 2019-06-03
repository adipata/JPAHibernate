/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eni.jpa.entity.convertisseur;

import com.eni.jpa.enumeration.Genre;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author martial
 */
@Converter
public class GenreConvertisseur implements AttributeConverter<Genre, String>{

    @Override
    public String convertToDatabaseColumn(Genre attribute) {
        if(attribute == null){
            return null;
        }
        switch (attribute){ 
            case FEMME : return "F";
            case HOMME : return "H";
            default : return null;
        }
    }

    @Override
    public Genre convertToEntityAttribute(String dbData) {
        if(dbData == null || "".equalsIgnoreCase(dbData.trim())){
            return null;
        }
        String tmp = dbData.trim().toUpperCase();
        if("F".equals(tmp)){
            return Genre.FEMME;
        }else if("M".equals(tmp)){
            return Genre.HOMME;
        }else{
            return null;
        }
            
    }
    
}

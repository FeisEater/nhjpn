/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import java.util.ArrayList;

/**
 *
 * @author niko
 * Metodeja, jotka saavat syötteenä esim kirjailijat tai julkaisuvuoden ja
 * muotoilevat sen bibtext tiedoston edellyttämään muotoon
 */
public class Formatter {
    ArrayList<String> tags;
    
    
    public Formatter(ArrayList<String> tags) {
        this.tags = tags;
    }
    
    /**
     * Luo uniikin tagin kirjailijan/kirjailijoiden nimen ja julkaisuvuoden
     * perusteella
     * 
     * @param nameList kirjailijoiden nimet
     * @param year julkaisuvuosi
     * @return
     */
    public String formatTag(String[] nameList, String year) {
        year = year.substring(2);
        String tag = "";
        
        if (nameList.length == 2) {
            tag += nameList[1];
        } else {
            for (int i = 1; i < nameList.length; i+=2) {
                tag += nameList[i].substring(0, 1);
            }
        }
        
        tag += year;
        
        while (tagIsUsed(tag)) {
            tag += "I";
        }
        
        return tag;
    }
    
    /**
     * Tarkistaa onko luotu tagi jo käytetty
     * 
     * @param tag Tarkistettava luotu tagi
     * @return 
     */
    private boolean tagIsUsed(String tag) {
        if (tags.contains(tag)) {
            return true;
        }
        
        return false;
    }
    
    public String formatAuthors(String[] nameList) {
        String authors = "author = {";
        
        for (int i = 1; i < nameList.length; i+=2) {
            authors += nameList[i];
            authors += ", ";
            authors += nameList[i-1];
            
            if (i != nameList.length-1) {
                authors += " and ";
            }
        }
        
        authors += "}," + System.getProperty("line.separator");
        
        return authors;
    }
    
    public String formatTitle(String title) {
        return "title = {" + title + "}," + System.getProperty("line.separator");
    }
    public String formatYear(String year) {
        return "title = {" + year + "}," + System.getProperty("line.separator");
    }
    public String formatPublisher(String publisher) {
        return "title = {" + publisher + "}," + System.getProperty("line.separator");
    }
}

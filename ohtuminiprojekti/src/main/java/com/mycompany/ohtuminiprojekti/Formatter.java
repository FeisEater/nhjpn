/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

/**
 *
 * @author niko
 * metodeja jotka saavat syötteenä esim kirjailijat tai julkaisuvuoden ja
 * muotoilevat sen bibtext tiedoston edellyttämään muotoon
 */
public class Formatter {
    
    
    
    public Formatter() {
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
        
        authors += "},\n";
        
        return authors;
    }
    
    public String formatTitle(String title) {
        return "title = {" + title + "},\n";
    }
    
    public String formatYear(String title) {
        return "year = {" + title + "},\n";
    }
    
    public String formatPublisher(String publisher) {
        return "publisher = {" + publisher + "},\n";
    }
}

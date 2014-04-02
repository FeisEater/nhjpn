/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

/**
 *
 * @author niko
 */
public class Formatter {
    
    public Formatter() {
    }
    
    public String formatAuthors(String[] names) {
        String authors = "author = {";
        
        for (int i = 0; i < names.length; i++) {
            authors += names[i];
            
            if (i != names.length-1) {
                authors += " and ";
            }
        }
        
        authors += "},";
        
        return authors;
    }
}

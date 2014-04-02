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
 */
public class Formatter {
    
    public Formatter() {
    }
    
    public String formatAuthors(String[] nameList) {
        String authors = "author = {";
        
        for (int i = 0; i < nameList.length; i+=2) {
            authors += nameList[i-1];
            authors += ", ";
            authors += nameList[i];
            
            if (i != nameList.length-1) {
                authors += " and ";
            }
        }
        
        authors += "},";
        
        return authors;
    }
}

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
public class SpecialCharacterHandler {
    public SpecialCharacterHandler() {
    }
    
    public String replaceSpecialCharacters(String line) {
        line = line.replace("ä", "{\"a}");
        line = line.replace("Ä", "{\"A}");
        line = line.replace("ö", "{\"o}");
        line = line.replace("Ö", "{\"O}");
        
        return line;
    }
}

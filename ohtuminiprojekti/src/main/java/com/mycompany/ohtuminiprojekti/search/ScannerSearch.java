/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author niko
 */
public class ScannerSearch implements Search {
    String found;
    
    public ScannerSearch() {
        found = "";
    }
    
    @Override
    public String search(String filename, String type, String keyword) {
        Scanner reader = new Scanner(filename);
        // yksittäisen julkaisun tiedot
        Map<String, String> info = new HashMap<String, String>();
        String line;
        
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            
            // jos kyseessä julkaisun loppu
            if (line.charAt(0) == '}') {
                if (info.get(line).contains(keyword)) {
                    stash(info);
                }
                info.clear();
                line = reader.nextLine();
                line = reader.nextLine();
            }
            
            // lisätään julkaisun tieto talteen jatkokäsittelyä varten
            if (line.charAt(0) == '@') {
                info.put(line.substring(1, line.indexOf('{')), line.substring(line.indexOf("{")+1, line.length()-1));
            } else {
                info.put(line.substring(0, line.indexOf("=")), line.substring(line.indexOf("{")+1, line.length()-2));
            }
        }
        
        return found;
    }
    
    private void stash(Map<String, String> info) {
        for (String key : info.keySet()) {
            found += key + ": " + info.get(key);
        }
        found += System.getProperty("line.separator");
    }
}

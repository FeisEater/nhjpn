/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti.search;

import java.io.File;
import java.io.IOException;
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
        try {
            Scanner reader = new Scanner(new File("references.txt"));
            // yksittäisen julkaisun tiedot
            Map<String, String> info = new HashMap<String, String>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                
                if (line.isEmpty()) {
                    continue;
                }

                // jos kyseessä julkaisun loppu
                if (line.charAt(0) == '}') {
                    if (info.get(type).contains(keyword)) {
                        stash(info);
                    }
                    info.clear();
                    reader.nextLine();
                } else {
                    // lisätään julkaisun tieto talteen jatkokäsittelyä varten
                    if (line.contains("@")) {
                        info.put(line.substring(1, line.indexOf('{')), line.substring(line.indexOf("{")+1, line.length()));
                    } else {
                        info.put(line.substring(0, line.indexOf("=")-1), line.substring(line.indexOf("{")+1, line.length()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Virhe haussa! " + e.getMessage());
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

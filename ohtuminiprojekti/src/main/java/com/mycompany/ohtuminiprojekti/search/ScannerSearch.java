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
    private Scanner reader;
    private Map<String, String> info;
    private String line;
    private String found;
    
    public ScannerSearch() {
        // yksittäisen julkaisun tiedot
        info = new HashMap<String, String>();
        found = "";
    }
    
    @Override
    public String search(String filename, String type, String keyword) throws IOException {
        reader = new Scanner(new File(filename));

        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            checkLine(type, keyword);
        }
        
        return found;
    }
    
    private void stash(Map<String, String> info) {
        for (String key : info.keySet()) {
            found += key + ": " + info.get(key) + System.getProperty("line.separator");
            
        }
        found += System.getProperty("line.separator");
    }
    
    private void handleLastLineOfReference(String type, String keyword) {
        String joku = info.get(type);
        if (joku != null && info.get(type).contains(keyword)) {
            stash(info);
        }
        info.clear();
    }
    
    private void addSingleLineOfReference() {
        if (!line.contains("@")) {
            if (line.charAt(0) == '%') {
                info.put("category", line.substring(1, line.length()));
            } else {
                info.put(line.substring(0, line.indexOf('=')-1), line.substring(line.indexOf('{')+1, line.length()-2));
            }
        }
    }
    
    private void checkLine(String type, String keyword) {
        if (line.charAt(0) == '}') {
            handleLastLineOfReference(type, keyword);
        } else {
            addSingleLineOfReference();
        }
    }
}

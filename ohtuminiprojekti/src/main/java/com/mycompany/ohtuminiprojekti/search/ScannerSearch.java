/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Julkaisujen tietojen hakemisesta huolehtiva luokka. Hakee jonkin 
 * tietotyypin (esim.author, title) ja sieltä etsittävän sanan perusteella ja
 * palauttaa merkkijonona osumat.
 * 
 * @author niko
 */
public class ScannerSearch implements Search {
    private Scanner reader;
    private Map<String, String> info;
    private String line;
    private String found;
    
    public ScannerSearch() {
        info = new HashMap<String, String>();
    }
    
    /**
     * Haun kokonaisuutta pyörittävä metodi. Käy annetun tiedoston läpi
     * rivi riviltä.
     * 
     * @param filename Tiedosto, josta etsitään.
     * @param type Tietotyyppi, johon hakusana kohdistetaan.
     * @param keyword Käytettävä hakusana.
     * @return Palauttaa merkkijonoesityksen osumista.
     */
    @Override
    public String search(String filename, String type, String keyword) {
        initialize(filename);

        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            checkLine(type, keyword);
        }
        
        return found;
    }
    
    /**
     * Alustaa scannerin ja tyhjentää edellisen haun osumat.
     * 
     * @param filename Tiedosto, josta etsitään.
     */
    private void initialize(String filename) {
        try {
            reader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Virhe haussa! " + e.getMessage());
        }
        found = "";
    }
    
    /**
     * Lisää osumat palautettavaan merkkijonoon.
     * 
     * @param info 
     */
    private void stash(Map<String, String> info) {
        for (String key : info.keySet()) {
            found += key + ": " + info.get(key) + System.getProperty("line.separator");
            
        }
        found += System.getProperty("line.separator");
    }
    
    /**
     * Hoitaa tilanteen, kun ollaan saavuttu yksittäisen julkaisun
     * viimeiselle riville. Laitetaan julkaisu talteen merkkijonoomme, jos
     * osuma ja tyhjennetään mapistamme tämän julkaisun tiedot, jotta saadaan
     * seuraava tilalle.
     * 
     * @param type Tietotyyppi, johon hakusana kohdistetaan.
     * @param keyword Käytettävä hakusana.
     */
    private void handleLastLineOfReference(String type, String keyword) {
        String joku = info.get(type);
        if (joku != null && info.get(type).contains(keyword)) {
            stash(info);
        }
        info.clear();
    }
    
    /**
     * Lisätään käsiteltävä rivi mappiimme, josta se on helppo hakea
     * palautettavaan merkkijonoomme lisättäväksi, jos saamme osuman.
     */
    private void addSingleLineOfReference() {
        if (!line.contains("@")) {
            if (line.charAt(0) == '%') {
                info.put("category", line.substring(1, line.length()));
            } else {
                info.put(line.substring(0, line.indexOf('=')-1), line.substring(line.indexOf('{')+1, line.length()-2));
            }
        }
    }
    
    /**
     * Tarkistetaan onko kyseessä yksittäisen julkaisun viimeinen rivi
     * vai joku käsiteltävistä riveistä.
     * 
     * @param type Tietotyyppi, johon hakusana kohdistetaan.
     * @param keyword Käytettävä hakusana.
     */
    private void checkLine(String type, String keyword) {
        if (line.charAt(0) == '}') {
            handleLastLineOfReference(type, keyword);
        } else {
            addSingleLineOfReference();
        }
    }
}

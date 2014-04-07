/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author niko
 * 
 * Writerin toteuttava luokka, joka kirjoittaa syötetyn kirjan tiedot bibtext tiedostoon
 */
public class BookWriter implements Writer {
    FileWriter writer;
    Formatter formatter;
    SpecialCharacterHandler handler;

    public BookWriter(ArrayList<String> tags) throws IOException {
         formatter = new Formatter(tags);
         handler = new SpecialCharacterHandler();
    }
    
    @Override
        public void write(String[] types,String[] info, String tiedostonNimi) throws IOException{
        try {
            writer = new FileWriter(tiedostonNimi, true);
        } catch (IOException e) {
            writer = new FileWriter(tiedostonNimi + ".bib");
        }
        writer.append(handler.replaceSpecialCharacters("@book{" + formatter.formatTag(info[0].split(" "), info[2]) + "," + System.getProperty("line.separator")));
        writer.append(handler.replaceSpecialCharacters(formatter.formatAuthors(info[0].split(" "))));
        for(int i = 1; i < types.length; i ++){
            writer.append(handler.replaceSpecialCharacters(formatter.format(info[i], types[i])));
        }
        writer.append("}" + System.getProperty("line.separator") + System.getProperty("line.separator"));
        
//        writer.append(handler.replaceSpecialCharacters("@book{" + formatter.formatTag(info[0].split(" "), info[2]) + "," + System.getProperty("line.separator")));
//        writer.append(handler.replaceSpecialCharacters(formatter.formatAuthors(info[0].split(" "))));
//        writer.append(handler.replaceSpecialCharacters(formatter.format(info[1], types[1])));
//        writer.append(handler.replaceSpecialCharacters(formatter.format(info[2], types[2])));
//        writer.append(handler.replaceSpecialCharacters(formatter.format(info[3], types[3])));
//        writer.append("}" + System.getProperty("line.separator") + System.getProperty("line.separator"));
        writer.close();
    }

}

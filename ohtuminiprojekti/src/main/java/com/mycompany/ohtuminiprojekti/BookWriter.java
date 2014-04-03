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
    public void write(String[] info) throws IOException{
        try {
            writer = new FileWriter("references.txt", true);
        } catch (IOException e) {
            writer = new FileWriter("references.txt");
        }
        
        writer.append(handler.replaceSpecialCharacters("@book{" + formatter.formatTag(info[0].split(" "), info[2]) + ",\n"));
        writer.append(handler.replaceSpecialCharacters(formatter.formatAuthors(info[0].split(" "))));
        writer.append(handler.replaceSpecialCharacters(formatter.formatTitle(info[1])));
        writer.append(handler.replaceSpecialCharacters(formatter.formatYear(info[2])));
        writer.append(handler.replaceSpecialCharacters(formatter.formatPublisher(info[3])));
        writer.append("}\n\n");
        writer.close();
    }
}

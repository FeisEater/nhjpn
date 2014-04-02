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

    public BookWriter(ArrayList<String> tags) throws IOException {
         writer = new FileWriter(new File("references.txt"));
         formatter = new Formatter(tags);
    }
    
    public void write(String[] info) throws IOException {
        writer.append("@book{" + formatter.formatTag(info[0].split(" "), info[2]) + ",\n");
        writer.append(formatter.formatAuthors(info[0].split(" ")));
        writer.append(formatter.formatTitle(info[1]));
        writer.append(formatter.formatYear(info[2]));
        writer.append(formatter.formatPublisher(info[3]));
        writer.append("}\n\n");
    }
}

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
 */
public class BookWriter implements Writer {
    FileWriter writer;
    Formatter formatter;

    public BookWriter() throws IOException {
         writer = new FileWriter(new File("references.txt"));
         formatter = new Formatter();
    }
    
    public void write(String[] info) throws IOException {
        writer.append(formatter.formatAuthors(info[0].split(" ")));
    }
}

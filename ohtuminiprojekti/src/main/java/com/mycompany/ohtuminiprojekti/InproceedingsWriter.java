
package com.mycompany.ohtuminiprojekti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class InproceedingsWriter implements Writer{
    FileWriter writer;
    Formatter formatter;
    SpecialCharacterHandler handler;

    public InproceedingsWriter(ArrayList<String> tags) throws IOException {
         formatter = new Formatter(tags);
         handler = new SpecialCharacterHandler();
    }

        public void write(String[] info, String tiedostonNimi) throws IOException{
        try {
            writer = new FileWriter(tiedostonNimi, true);
        } catch (IOException e) {
            writer = new FileWriter(tiedostonNimi + ".bib");
        }
        
        writer.append(handler.replaceSpecialCharacters("@inproceedings{" + formatter.formatTag(info[0].split(" "), info[2]) + "," + System.getProperty("line.separator")));
        writer.append(handler.replaceSpecialCharacters(formatter.formatAuthors(info[0].split(" "))));

        writer.append("}" + System.getProperty("line.separator") + System.getProperty("line.separator"));
        writer.close();
    }

    @Override
    public void write(String[] info, String[] types, String tiedostonNimi) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

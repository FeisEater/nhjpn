
package com.mycompany.ohtuminiprojekti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class ArticleWriter implements Writer {
    FileWriter writer;
    Formatter formatter;
    SpecialCharacterHandler handler;

    public ArticleWriter(ArrayList<String> tags) throws IOException {
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
        
        writer.append(handler.replaceSpecialCharacters("@article{" + formatter.formatTag(info[0].split(" "), info[2]) + "," + System.getProperty("line.separator")));
        writer.append(handler.replaceSpecialCharacters(formatter.formatAuthors(info[0].split(" "))));
        writer.append(handler.replaceSpecialCharacters(formatter.formatTitle(info[1])));
        writer.append(handler.replaceSpecialCharacters(formatter.formatYear(info[2])));
        writer.append(handler.replaceSpecialCharacters(formatter.formatJournal(info[3])));
        writer.append("}" + System.getProperty("line.separator") + System.getProperty("line.separator"));
        writer.close();
    }
    
}

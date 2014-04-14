package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.IO.IO;
import java.io.IOException;
import java.util.ArrayList;

public class Reference {

    private final IO io;
    private Writer writer;
    
    public Reference(IO io) {
        this.io = io;
        ArrayList<String> list = new ArrayList<>();
        try{
            writer = new TypeWriter(list);
        } catch (IOException e){io.output("wrtitteria ei luotu" + e);}
    }
    
    public void addBook() {
        String info[] = {askAuthors(), askInfo("title"), askInfo("year"), askInfo("publisher")};
        String types[] = {"authors", "title", "year", "publisher"};
        if (getConfirmation(info)) {
            save(types, info, "@book");
        } else {
            io.output("Kirjaa ei tallennettu");
        }
    }

    
    public void addInproceedings() {
        String info[] = {askAuthors() ,askInfo("title"),askInfo("year"),askInfo("booktitle"),askInfo("pages"),askInfo("publisher")};
        String types[] = {"authors", "title", "year", "booktitle", "pages", "publisher"};
        if (getConfirmation(info)) {
            save(types, info, "@inproceedings");
        } else {
            io.output("Inproceedings ei tallennettu");
        }
    }
    
    public void addArticle() {
        String info[] = {askAuthors() ,askInfo("title"),askInfo("year"),askInfo("journal")};
        String types[] = {"authors", "title", "year", "journal"};
        if (getConfirmation(info)) {
            save(types, info, "@article");
        } else {
            io.output("Inproceedings ei tallennettu");
        }
    }
    
    public void save(String[] type, String[] info, String referenceType){
        try {
            io.output("Anna tallennettavan tiedoston nimi (älä anna tiedostonpäätettä):");
            String tiedostonNimi = io.nextInput();
            writer.write(type, info, referenceType, tiedostonNimi + ".bib");
            
        } catch (IOException e) {
            io.output("Tallennus ei onnistunut");
        }
    }
    
    public boolean getConfirmation(String[] info){
        io.output("Annoit seuraavat tiedot:");
        for (String infot : info) {
            io.output(infot);
        }
        io.output("Tallennetaanko? (k/e)");
        String save = io.nextInput();
        return save.equals("k");
    }
    
    public String askAuthors(){
        io.output("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):");
        String authors = "";
        while(true){
            String line = io.nextInput();
            if (line.equals("")) {
                break;
            }
            authors += line + ":";
        }
        return authors;
    }
    
    public String askInfo(String info){
        while(true){
            io.output("Anna " + info);
            String jtn = io.nextInput();
            if(jtn.length() > 2){
                return jtn;
            }
        }
    }

}
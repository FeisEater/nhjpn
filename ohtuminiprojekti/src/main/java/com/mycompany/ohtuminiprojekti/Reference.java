package com.mycompany.ohtuminiprojekti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reference {

    private final Scanner scanner;
    private Writer writer;
    
    public Reference(Scanner scanner) {
        this.scanner = scanner;
        ArrayList<String> list = new ArrayList<>();
        try{
            writer = new TypeWriter(list);
        } catch (IOException e){System.out.println("wrtitteria ei luotu" + e);}
    }
    
    public void addBook() {
        String info[] = {askAuthors(), askInfo("title"), askInfo("year"), askInfo("publisher")};
        String types[] = {"authors", "title", "year", "publisher"};
        if (getConfirmation(info)) {
            save(types, info, "@book");
        } else {
            System.out.println("Kirjaa ei tallennettu");
        }
    }

    
    public void addInproceedings() {
        String info[] = {askAuthors() ,askInfo("title"),askInfo("year"),askInfo("booktitle"),askInfo("pages"),askInfo("publisher")};
        String types[] = {"authors", "title", "year", "booktitle", "pages", "publisher"};
        if (getConfirmation(info)) {
            save(types, info, "@inproceedings");
        } else {
            System.out.println("Inproceedings ei tallennettu");
        }
    }
    
    public void addArticle() {
        String info[] = {askAuthors() ,askInfo("title"),askInfo("year"),askInfo("journal")};
        String types[] = {"authors", "title", "year", "journal"};
        if (getConfirmation(info)) {
            save(types, info, "@article");
        } else {
            System.out.println("Inproceedings ei tallennettu");
        }
    }
    
    public void save(String[] type, String[] info, String referenceType){
        try {
            System.out.println("Anna tallennettavan tiedoston nimi (älä anna tiedostonpäätettä): ");
            String tiedostonNimi = scanner.nextLine();
            writer.write(type, info, referenceType, tiedostonNimi + ".bib");

        } catch (IOException e) {
            System.out.println("Kirjan tallennus ei onnistunut " + e);
        }
    }
    
    public boolean getConfirmation(String[] info){
        System.out.println("Annoit seuraavat tiedot:");
        for (String infot : info) {
            System.out.println(infot);
        }
        System.out.println("Tallennetaanko? (k/e)");
        String save = scanner.nextLine();
        return save.equals("k");
    }
    
    public String askAuthors(){
        System.out.println("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):");
        String authors = "";
        while(true){
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            authors += line + " ";
        }
        return authors;
    }
    
    public String askInfo(String info){
        System.out.println("Anna " + info);
        return scanner.nextLine();
    }

}
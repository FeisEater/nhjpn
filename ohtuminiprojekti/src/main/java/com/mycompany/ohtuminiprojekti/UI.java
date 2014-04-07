package com.mycompany.ohtuminiprojekti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private final Scanner scanner;
    private BookWriter bookwriter;
    
    public UI() {
        scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        try{
            bookwriter = new BookWriter(list);
        } catch (IOException e){System.out.println("writteria ei luotu" + e);}
    }
    
    public void addKirja() {
        String authors = askAuthors();
        String title = askInfo("title");
        String year = askInfo("year");
        String publisher = askInfo("publisher");
        String info[] = {authors, title, year, publisher};
        String types[] = {"authors", "title", "year", "publisher"};
        if (getConfirmation(info)) {
            saveKirja(info, types);
        } else {
            System.out.println("Kirjaa ei tallennettu");
        }
    }
    
    public void addInproceedings() {
        String authors = askAuthors();
        String info[] = {askAuthors() ,askInfo("title"),askInfo("year"),askInfo("booktitle"),askInfo("pages"),askInfo("publisher"),};
        String types[] = {"authors", "title", "year", "booktitle", "pages", "publisher"};
        if (getConfirmation(info)) {
            saveKirja(info, types);
        } else {
            System.out.println("Inproceedings ei tallennettu");
        }
    }
    
    public void saveKirja(String[] info, String[] types){
        try {
            System.out.println("Anna tallennettavan tiedoston nimi (älä anna tiedostonpäätettä): ");
            String tiedostonNimi = scanner.nextLine();
            bookwriter.write(info, types, tiedostonNimi + ".bib");
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
        System.out.println("Anna Author");
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
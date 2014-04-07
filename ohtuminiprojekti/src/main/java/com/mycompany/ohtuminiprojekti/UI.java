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
        String title = askInfo("teoksen nimi:");
        String year = askInfo("julkaisuvuosi:");
        String publisher = askInfo("julkaisija:");
        String info[] = {authors, title, year, publisher};
        if (getConfirmation(info)) {
            saveKirja(info);
        } else {
            System.out.println("Kirjaa ei tallennettu");
        }
    }
    
    public void saveKirja(String[] info){
        try {
            System.out.println("Anna tallennettavan tiedoston nimi (älä anna tiedostonpäätettä): ");
            String tiedostonNimi = scanner.nextLine();
            bookwriter.write(info, tiedostonNimi + ".bib");
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
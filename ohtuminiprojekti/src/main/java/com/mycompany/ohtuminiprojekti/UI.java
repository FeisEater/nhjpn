/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.search.ScannerSearch;
import com.mycompany.ohtuminiprojekti.search.Search;
import java.util.Scanner;

/**
 *
 * @author joonas
 */
public class UI {
    
    private Scanner scanner;
    private Reference reference;
    
    public UI(Scanner scanner){
        this.scanner = scanner;
        this.reference = new Reference(scanner);
    }
    
    public void run(){
        boolean run = true;
        while (run) {
            System.out.println("Welcome");
            System.out.println("add, search or exit?");
            String komento = scanner.nextLine();
            switch (komento) {
                case "add":
                    addReference();
                    break;
                case "search":
                    searchReference();
                    break;
                default:
                    run = false;
                    break;
            }

        }
    }

    private void addReference() {
        System.out.println("book, inproceedings or article?");
        String komento = scanner.nextLine();
        switch (komento) {
            case "book":
                this.reference.addBook();
                break;
            case "inproceedings":
                this.reference.addInproceedings();
                break;
            case "article":
                this.reference.addArticle();
                break;
            default: 
                break;
        }
    }

    private void searchReference() {
        Search haku = new ScannerSearch();
        System.out.println(haku.search("references.txt", "author", "Halonen"));
    }
    
}

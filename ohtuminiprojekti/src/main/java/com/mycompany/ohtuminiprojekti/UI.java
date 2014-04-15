/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.search.ScannerSearch;
import com.mycompany.ohtuminiprojekti.search.Search;
import com.mycompany.ohtuminiprojekti.IO.IO;
import java.io.IOException;

/**
 *
 * @author joonas
 */
public class UI {
    
    private IO io;
    private Reference reference;
    private Search haku;
    
    public UI(IO io){
        this.io = io;
        this.reference = new Reference(io);
        this.haku = new ScannerSearch();
    }
    
    public void run(){
        boolean run = true;
        while (run) {
            io.output("Welcome");
            io.output("add, search or exit?");
            String komento = io.nextInput();
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
        io.output("book, inproceedings or article?");
        String komento = io.nextInput();
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
        io.output("Give name of the file");
        String file = io.nextInput();
        io.output("Give type to search for");
        String type = io.nextInput();
        io.output("Give keyword to search for");
        String keyword = io.nextInput();
<<<<<<< HEAD
        io.output("");
        io.output(haku.search(file, type, keyword));
=======
        System.out.println("");
        try {
            System.out.println(haku.search(file + ".bib", type, keyword));
        } catch (IOException e) {
            System.out.println("Virhe haussa!" + e.getMessage());
        }
>>>>>>> f6ea7f7c00ea888cee63f3c0ec434e9fac6c6e4d
    }
    
    
}

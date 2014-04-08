/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.search.ScannerSearch;
import com.mycompany.ohtuminiprojekti.search.Search;
import com.mycompany.ohtuminiprojekti.IO.IO;

/**
 *
 * @author joonas
 */
public class UI {
    
    private IO io;
    private Reference reference;
    
    public UI(IO io){
        this.io = io;
        this.reference = new Reference(io);
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
        Search haku = new ScannerSearch();
        System.out.println(haku.search("references.txt", "author", "Halonen"));
    }
    
    
}

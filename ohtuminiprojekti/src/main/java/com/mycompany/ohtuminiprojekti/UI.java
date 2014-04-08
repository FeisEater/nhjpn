/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

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
            System.out.println("Welcome");
            System.out.println("add, search or exit?");
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

    public void addReference() {
        System.out.println("book, inproceedings or article?");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

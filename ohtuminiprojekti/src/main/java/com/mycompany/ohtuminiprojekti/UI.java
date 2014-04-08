/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

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
        System.out.println("Welcome");
        System.out.println("add, search or exit?");
        String komento = scanner.nextLine();
        if(komento.equals("add")){
            addReference();
        } else if(komento.equals("search")){
            
        } else if (komento.equals("exit")){
            
        }
        
    }

    private void addReference() {
        System.out.println("book, inproceedings or article?");
        String komento = scanner.nextLine();
        if(komento.equals("book")){
            this.reference.addKirja();
        } else if (komento.equals("inproceedings")){
            this.reference.addInproceedings();
        } else if (komento.equals(("article"))){
            this.reference.addArticle();
        }
    }
    
}

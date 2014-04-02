
package com.mycompany.ohtuminiprojekti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner scanner;
    private BookWriter bookwriter;
    
    public UI() {    
        scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        try{
            bookwriter = new BookWriter(list);
        } catch (Exception e){System.out.println("wrtitteria ei luotu" + e);}
    }
    
    public void addKirja(){
        System.out.println("Anna Author");
        //String author = scanner.nextLine();
        System.out.println("Anna Title");
        //String title = scanner.nextLine();
        System.out.println("Anna Year");
        //String year = scanner.nextLine();
        System.out.println("Anna Publisher");
        //String publisher = scanner.nextLine();
        //System.out.println("tallennetaanko? (kyllä, ei)");
        String info[] = {"Matti Koskinen Pentti Arajarvi", "title", "1999", "publisher"};
        
        try {
            bookwriter.write(info);
        } catch (Exception e) {
            System.out.println("ei onnaa " + e);
        }
    }

}

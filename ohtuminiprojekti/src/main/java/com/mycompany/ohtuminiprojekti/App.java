package com.mycompany.ohtuminiprojekti;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(scanner);
        ui.run();
    }
}

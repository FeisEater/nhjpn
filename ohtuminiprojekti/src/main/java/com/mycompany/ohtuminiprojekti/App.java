package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.IO.IO;
import com.mycompany.ohtuminiprojekti.IO.TerminalIO;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IO io = new TerminalIO();
        UI ui = new UI(io);
        ui.run();
    }
}

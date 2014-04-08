
package com.mycompany.ohtuminiprojekti.IO;

import java.util.Scanner;

/**
 *
 * @author Pavel
 */
public class TerminalIO implements IO {
    private Scanner scanner;
    public TerminalIO()
    {
        scanner = new Scanner(System.in);
    }
    @Override
    public String nextInput() {
        return scanner.nextLine();
    }

    @Override
    public void output(String out) {
        System.out.println(out);
    }
    
}

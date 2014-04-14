
package com.mycompany.ohtuminiprojekti;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Pavel
 */
public class ScannerForTest {
    private Scanner scanner;
    private String filecontent;
    public ScannerForTest(String filename) throws FileNotFoundException
    {
        scanner = new Scanner(new File(filename));
    }
    public void readFile()
    {
        filecontent = "";
        while (scanner.hasNextLine())
            filecontent += scanner.nextLine();
    }
    public boolean omametodi(String s)
    {
        return filecontent.contains(s);
    }
}

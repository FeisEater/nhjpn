
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
    private File file;
    public ScannerForTest(String filename) throws FileNotFoundException
    {
        file = new File(filename);
        for (int i = 0; i < 100000; i++)
            if (file.exists())  break;
        scanner = new Scanner(file);
    }
    public void readFile()
    {
        filecontent = "";
        while (scanner.hasNextLine())
            filecontent += scanner.nextLine();
    }
    public boolean contains(String s)
    {
        return filecontent.contains(s);
    }
    public void close()
    {
        scanner.close();
        file.delete();
    }
}

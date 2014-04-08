
package com.mycompany.ohtuminiprojekti;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pavel
 */
public class FormatterTest {
    Formatter f;
    public FormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("abc95");
        a.add("def01");
        a.add("ghi64");
        f = new Formatter(a);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void formatsAuthors()
    {
        String[] namelist = {"afirst", "alast", "bfirst", "blast"};
        assertTrue(f.formatAuthors(namelist),f.formatAuthors(namelist).contains("author = {alast, afirst and blast, bfirst},"));
    }
    @Test
    public void formatsOneAuthor()
    {
        String[] namelist = {"first", "last"};
        assertTrue(f.formatAuthors(namelist).contains("author = {last, first},"));
    }
    @Test
    public void formatsTitle()
    {
        assertTrue(f.format("title", "booktitle").contains("title = {booktitle},"));        
    }
    @Test
    public void formatsYear()
    {
        assertTrue(f.format("year", "1994").contains("year = {1994},"));        
    }
    @Test
    public void formatsPublisher()
    {
        assertTrue(f.format("publisher", "pub").contains("publisher = {pub},"));        
    }
    @Test
    public void formatsTag()
    {
        String[] namelist = {"hfirst", "zlast", "jfirst", "ylast", "kfirst", "xlast"};
        assertTrue(f.formatTag(namelist, "1991").equals("zyx91"));
    }
    @Test
    public void formatsTagForOneWriter()
    {
        String[] namelist = {"first", "last"};
        assertTrue(f.formatTag(namelist, "1989").equals("last89"));
    }
    @Test
    public void formatsExistingTag()
    {
        String[] namelist = {"hfirst", "alast", "jfirst", "blast", "kfirst", "clast"};
        assertTrue(f.formatTag(namelist, "1995"),f.formatTag(namelist, "1995").equals("abc95I"));
    }
}

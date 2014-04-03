/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        assertTrue(f.formatAuthors(namelist).equals("author = {alast, afirst and blast, bfirst},\n"));
    }
    @Test
    public void formatsOneAuthor()
    {
        String[] namelist = {"first", "last"};
        assertTrue(f.formatAuthors(namelist).equals("author = {last, first},\n"));
    }
    @Test
    public void formatsTitle()
    {
        assertTrue(f.formatTitle("booktitle").equals("title = {booktitle},\n"));        
    }
    @Test
    public void formatsYear()
    {
        assertTrue(f.formatYear("1994").equals("year = {1994},\n"));        
    }
    @Test
    public void formatsPublisher()
    {
        assertTrue(f.formatPublisher("pub").equals("publisher = {pub},\n"));        
    }
    @Test
    public void formatsTag()
    {
        String[] namelist = {"zlast", "zfirst", "ylast", "yfirst", "xlast", "xfirst"};
        assertTrue(f.formatTag(namelist, "1991").equals("zyx91"));
    }
    @Test
    public void formatsTagForOneWriter()
    {
        String[] namelist = {"last", "first"};
        assertTrue(f.formatTag(namelist, "1989").equals("first89"));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.IO.IO;
import com.mycompany.ohtuminiprojekti.IO.StubIO;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
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
public class UITest {
    
    private UI ui;
    private StubIO io;
    
    public UITest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.io = new StubIO();
        this.ui = new UI(io);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void runAddReferencePrintsCorrect()
    {
        io.addInput("add");
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ui.run();
        assertTrue("book, inproceedings or article?".equals(io.getOutput(2)));
 
    }
    
    @Test
    public void runPrintsCorrect()
    {
        io.addInput("add");
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ui.run();
        assertTrue("Welcome".equals(io.getOutput(0)));
        assertTrue("add, search or exit?".equals(io.getOutput(1)));
 
    }
    
    @Test
    public void runAddReferenceBookPrintsCorrect()
    {
        io.addInput("add");
        io.addInput("book");
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ui.run();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(3)));
 
    }
    
    @Test
    public void runAddReferenceInproceedingsPrintsCorrect()
    {
        io.addInput("add");
        io.addInput("book");
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ui.run();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(3)));
 
    }
    
    @Test
    public void runAddReferenceArticlePrintsCorrect()
    {
        io.addInput("add");
        io.addInput("book");
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ui.run();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(3)));
 
    }
}

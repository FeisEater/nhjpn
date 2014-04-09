/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import com.mycompany.ohtuminiprojekti.IO.StubIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joonas
 */
public class ReferenceTest {
    
    private Reference ref;
    private StubIO io;
    
    public ReferenceTest() {
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
        this.ref = new Reference(io);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addArticlePrintsCorrect() {
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ref.addArticle();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(0)));
        assertTrue("Annoit seuraavat tiedot:".equals(io.getOutput(4)));
        assertTrue("Tallennetaanko? (k/e)".equals(io.getOutput(9)));
    }
    @Test
    public void addInproceedingsPrintsCorrect() {
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ref.addInproceedings();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(0)));
        assertTrue("Annoit seuraavat tiedot:".equals(io.getOutput(6)));
        assertTrue("Tallennetaanko? (k/e)".equals(io.getOutput(13)));
    }
    @Test
    public void addBookPrintsCorrect() {
        for(int i = 0; i< 100; i++){
            io.addInput("");
        }
        ref.addBook();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(0)));
        assertTrue("Annoit seuraavat tiedot:".equals(io.getOutput(4)));
        assertTrue("Tallennetaanko? (k/e)".equals(io.getOutput(9)));

    }
    
    @Test
    public void getConfirmationPrintsCorrect() {
        io.addInput("");
        String[] info = {"test1", "test2"};
        ref.getConfirmation(info);
        assertTrue("Annoit seuraavat tiedot:".equals(io.getOutput(0)));
        assertTrue("test1".equals(io.getOutput(1)));
        assertTrue("test2".equals(io.getOutput(2)));
        assertTrue("Tallennetaanko? (k/e)".equals(io.getOutput(3)));
    }
    
    @Test
    public void askInfoPrintsCorrect() {
        ref.askInfo("book");
        assertTrue("Anna book".equals(io.getOutput(0)));
    }
    @Test
    public void askAuthorPrintsCorrect() {
        io.addInput("");
        ref.askAuthors();
        assertTrue("Anna kirjailija/kirjailijat (Etunimen ja sukunimen välissä paina Enter ja lopuksi vielä Enter):".equals(io.getOutput(0)));
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

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
    private Scanner scanner;
    
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
        this.scanner = new Scanner(System.in);
        ui = new UI(scanner);
    }
    
    @After
    public void tearDown() {
    }

    //@Test
    public void addReferenceBook()
    {
        ui.addReference();
        ByteArrayInputStream in = new ByteArrayInputStream("add".getBytes());
        System.setIn(in);
        
    }
}

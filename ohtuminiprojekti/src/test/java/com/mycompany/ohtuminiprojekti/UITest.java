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

    //@Test
    public void addRunBook()
    {
        io.addInput("add");
        ui.run();
        
        
        
    }
}

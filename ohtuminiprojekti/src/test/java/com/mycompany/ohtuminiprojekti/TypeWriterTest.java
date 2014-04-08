/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ohtuminiprojekti;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author hhkopper
 */
public class TypeWriterTest {

    private TypeWriter t;
    private ArrayList<String> tagit;
    private String[] types;
    private String[] info;
    private String tiedostonNimi;
    private String type;

    public TypeWriterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        this.tagit = new ArrayList<>();
        t = new TypeWriter(this.tagit);
        types = new String[]{"authors", "title", "year", "publisher"};
        info = new String[]{"Kalle Mäkinen", "Kellopeli", "2001", "wsoy"};
        tiedostonNimi = "testi";
        type = "Book";

    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkistetaanEttaTiedostoLuodaan() throws IOException {
        t.write(types, info, type, tiedostonNimi);
        assertNotNull(t.getWriter());
    }

}

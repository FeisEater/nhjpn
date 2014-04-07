/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti;

import java.io.IOException;

/**
 *
 * @author niko
 * 
 * Rajapinta, jonka toteuttavat luokat aina osaavat kirjoittaa yhden tyyppisen julkaisun
 * tiedot bibtext tiedostoon.
 */
public interface Writer {
    public void write(String[] info, String tiedostonNimi) throws IOException;
}

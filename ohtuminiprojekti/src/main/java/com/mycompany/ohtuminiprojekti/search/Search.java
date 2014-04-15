/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ohtuminiprojekti.search;

import java.io.IOException;

/**
 *
 * @author niko
 */
public interface Search {
    public String search(String filename, String type, String keyword) throws IOException;
}

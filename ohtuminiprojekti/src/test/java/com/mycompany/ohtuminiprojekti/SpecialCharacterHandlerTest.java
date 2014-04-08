
package com.mycompany.ohtuminiprojekti;

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
public class SpecialCharacterHandlerTest {
    private SpecialCharacterHandler sch;
    public SpecialCharacterHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sch = new SpecialCharacterHandler();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void replaceScandicLettersAareton()
    {
        String result = "\\" + "\"{A}" + "\\" + "\"{a}ret" + "\\" + "\"{o}n";
        assertTrue(result, sch.replaceSpecialCharacters("Ääretön").equals(result));
    }

    @Test
    public void replaceScandicLettersOtokka()
    {
        String result = "\\" + "\"{O}" + "t" + "\\" + "\"{o}kk" + "\\" + "\"{a}";
        assertTrue(result, sch.replaceSpecialCharacters("Ötökkä").equals(result));
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joonaskylliainen
 */
public class RatkaisijaAlgoritmiTest {
    
    public RatkaisijaAlgoritmiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    
    @Test
    public void toimiikoYlipaataan() {
        String[] esim1 = new String[]{
       "??53?????",
     "8??????2?",
     "?7??1?5??",
     "4????53??",
     "?1??7???6",
     "??32???8?",
     "?6?5????9",
     "??4????3?",
     "?????97??"};
        int[][] s = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (esim1[i].charAt(j) != '?') {
                    s[i][j] = Character.digit(esim1[i].charAt(j), 10);
                }
            }
        }
        int [][] sudoku = s;
        RatkaisijaAlgoritmi ratkaisija = new RatkaisijaAlgoritmi();
        sudoku = ratkaisija.vastaus(sudoku);
        
        assertEquals("[[I@35960f05", sudoku.toString());
    }
}

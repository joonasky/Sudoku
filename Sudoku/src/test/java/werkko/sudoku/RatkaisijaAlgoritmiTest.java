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

import java.util.Arrays;
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
        
        String[] esim2 = new String[]{
       "142653897",
     "835947621",
     "679812543",
     "496185372",
     "218374956",
     "753296184",
     "367528419",
     "984761235",
     "521439768"};
        
        int[][] s = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (esim1[i].charAt(j) != '?') {
                    s[i][j] = Character.digit(esim1[i].charAt(j), 10);
                }
            }
        }
        
        int[][] su = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (esim2[i].charAt(j) != '?') {
                    su[i][j] = Character.digit(esim1[i].charAt(j), 10);
                }
            }
        }
        
        int [][] sudoku = s;
        int [][] sudoku2 = su;
        RatkaisijaAlgoritmi ratkaisija = new RatkaisijaAlgoritmi();
        sudoku = ratkaisija.vastaus(sudoku);
        
        assertEquals(true, Arrays.deepEquals(s, su));
    }
}

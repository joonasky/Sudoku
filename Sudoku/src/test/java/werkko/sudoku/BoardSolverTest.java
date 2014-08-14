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
import java.util.Collections;
import java.util.HashSet;
/**
 *
 * @author joonaskylliainen
 */
public class BoardSolverTest {
    
    public static void tarkasta(int[][] s) {
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                assertTrue("Ratkaisusi sisälsi lukuja 0.", s[i][j]!=0);
            }
        }

        HashSet oikea = new HashSet();
        Collections.addAll(oikea,1,2,3,4,5,6,7,8,9);

        HashSet tark = new HashSet();
        for (int rivi = 0; rivi<9; rivi++) {
            tark.clear();
            for (int i = 0; i<9; i++) {
                tark.add(s[rivi][i]);
            }
            assertEquals("Rivi "+(rivi+1)+" ei ollut validi.",oikea,tark);
        }

        for (int sarake = 0; sarake<9; sarake++) {
            tark.clear();
            for (int i = 0; i<9; i++) {
                tark.add(s[i][sarake]);
            }
            assertEquals("Sarake "+(sarake+1)+" ei ollut validi.",oikea,tark);
        }

        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++) {
                tark.clear();
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        tark.add(s[3*x+i][3*y+j]);
                    }
                }
                assertEquals("Neliö "+(x+1)+","+(y+1)+" ei ollut validi.",oikea,tark);
            }
        }
    }
    
    public static int[][] toIntArray(String[] rs) {
        int[][] s = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rs[i].charAt(j) != '?') {
                    s[i][j] = Character.digit(rs[i].charAt(j), 10);
                }
            }
        }
        return s;
    }
    
    public BoardSolverTest() {
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
    public void testDifferentSudokus() {
        String[] str = {"846937152",
                        "319625847",
                        "752184963",
                        "285713694",
                        "463859271",
                        "971246385",
                        "127598436",
                        "638471529",
                        "594362718"};
        String[] str2 = {"005300000",
                         "800000020",
                         "070010500",
                         "400005300",
                         "010070006",
                         "003200080",
                         "060500009",
                         "004000030",
                         "000009700"};
        String[] str3 = {"000000000",
                         "000003085",
                         "001020000",
                         "000507000",
                         "004000100",
                         "090000000",
                         "500000070",
                         "002010000",
                         "000040009"};
        int[][] s1 = toIntArray(str);
        int[][] s2 = toIntArray(str2);
        int[][] s3 = toIntArray(str3);
        BoardSolver b = new BoardSolver();
        tarkasta(b.answer(s1));
        tarkasta(b.answer(s2));
        tarkasta(b.answer(s3));
    }
    
}

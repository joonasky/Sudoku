/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
public class BoardGeneratorTest {
    
    BoardGenerator g;
    
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
    
    public BoardGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new BoardGenerator();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void doesFileReaderWork() {
        int[][] s = g.generateFromFile();
        int [][] s2 = {{0,0,5,3,0,0,0,0,0},
        {8,0,0,0,0,0,0,2,0},
        {0,7,0,0,1,0,5,0,0},
        {4,0,0,0,0,5,3,0,0},
        {0,1,0,0,7,0,0,0,6},
        {0,0,3,2,0,0,0,8,0},
        {0,6,0,5,0,0,0,0,9},
        {0,0,4,0,0,0,0,3,0},
        {0,0,0,0,0,9,7,0,0}};
        boolean b = Arrays.deepEquals(s, s2);
        assertEquals(true, b);
//        assertFalse("File Reader ei toimi", Arrays.deepEquals(s, s2));
    }
    public void doesRandomFileReaderGenerateSameSudoku() {
        int[][] s1 = g.generateFromFileRandom();
        int [][] s2 = g.generateFromFileRandom();
        int [][] s3 = g.generateFromFileRandom();
        int[][] s4 = g.generateFromFileRandom();
        assertFalse("samaa sudokua pukkaa", Arrays.deepEquals(s1, s2) && Arrays.deepEquals(s2, s3) && Arrays.deepEquals(s3, s4));
    }
    public void doesRandomFileReaderGenerateValidSudokus() {
        int [][] s = {{0,0,5,3,0,0,0,0,0},
        {8,0,0,0,0,0,0,2,0},
        {0,7,0,0,1,0,5,0,0},
        {4,0,0,0,0,5,3,0,0},
        {0,1,0,0,7,0,0,0,6},
        {0,0,3,2,0,0,0,8,0},
        {0,6,0,5,0,0,0,0,9},
        {0,0,4,0,0,0,0,3,0},
        {0,0,0,0,0,9,7,0,0}};
        int[][] s1 = g.generateFromFileRandom();
        int [][] s2 = g.generateFromFileRandom();
        int [][] s3 = g.generateFromFileRandom();
        int[][] s4 = g.generateFromFileRandom();
        int[][] s5 = g.generateFromFileRandom();
        assertFalse("mikään sudoku viidestä ei ole tiedoston ensimmäinen", Arrays.deepEquals(s, s2) || Arrays.deepEquals(s, s3) || Arrays.deepEquals(s, s4) ||  Arrays.deepEquals(s, s5) );
    }
    public void AreRandomSudokusSolvable() {
        int[][] s1 = g.generateFromFileRandom();
        int [][] s2 = g.generateFromFileRandom();
        int [][] s3 = g.generateFromFileRandom();
        int[][] s4 = g.generateFromFileRandom();
        int[][] s5 = g.generateFromFileRandom();
        BoardSolver solver = new BoardSolver();
        s1 = solver.answer(s1);
        s2 = solver.answer(s2);
        s3 = solver.answer(s3);
        s4 = solver.answer(s4);
        s5 = solver.answer(s5);
        tarkasta(s1);
        tarkasta(s2);
        tarkasta(s3);
        tarkasta(s4);
        tarkasta(s5);
    }
}

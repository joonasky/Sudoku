/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

import java.util.Arrays;
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
        assertFalse("mikään sudoku viidestä ei ole tiedostonensimmäinen", Arrays.deepEquals(s, s2) || Arrays.deepEquals(s, s3) || Arrays.deepEquals(s, s4) ||  Arrays.deepEquals(s, s5) );
    }
}

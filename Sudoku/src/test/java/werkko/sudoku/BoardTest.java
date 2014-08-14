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
public class BoardTest {
    
    Board board;
    Board board2;
    Board board3;
    int[][] s;
    int[][] s2;    
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int [][] s = {{0,0,5,3,0,0,0,0,0},
        {8,0,0,0,0,0,0,2,0},
        {0,7,0,0,1,0,5,0,0},
        {4,0,0,0,0,5,3,0,0},
        {0,1,0,0,7,0,0,0,6},
        {0,0,3,2,0,0,0,8,0},
        {0,6,0,5,0,0,0,0,9},
        {0,0,4,0,0,0,0,3,0},
        {0,0,0,0,0,9,7,0,0}};
        int[][] s2 = {{1,4,5,3,2,7,6,9,8},
            {8,3,9,6,5,4,1,2,7},
            {6,7,2,9,1,8,5,4,3},
            {4,9,6,1,8,5,3,7,2},
            {2,1,8,4,7,3,9,5,6},
            {7,5,3,2,9,6,4,8,1},
            {3,6,7,5,4,2,8,1,9},
            {9,8,4,7,6,1,2,3,5},
            {5,2,1,8,3,9,7,6,4}};
        board = new Board();
        board2 = new Board(s);
        board3 = new Board(s2);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void toimiikoGenerateBoard() {
//        board.generateBoard();
//        assertEquals(true, Arrays.deepEquals(board.getBoard(), board2.getBoard()));
//    }
    @Test 
    public void toimiikoSolve() {
        board2.solve();
        assertEquals(true, Arrays.deepEquals(board2.getAnswer(), board3.getBoard()));
    }
}

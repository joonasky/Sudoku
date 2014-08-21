/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

import java.util.Arrays;
/**
 * Sudokupelin ydinluokka. Tekee pelinolion jolta löytyy erilaisia metodeja pelin toteuttamista varten.
 * @author joonaskylliainen
 */
public class Board {
    final int EMPTY = 0;             

    private int[][] board;
    private int[][] answer;
    private int[][] empty;
    
    /**
     *luo tyhjän pelilaudan
     */
    public Board() {
        board = new int[9][9];
        empty = new int[9][9];
    }
    
    /**
     * luo annetun pelin
     * @param sudoku konstruktorille annettu peli
     */
    public Board(int[][] sudoku) {
        board = sudoku;
        empty = new int[9][9];
    }
    
    /**
     * Asettaa yhteen laatikkoon numeron
     * @param x asetettava numero
     * @param row rivi jolle numero laitetaan
     * @param column sarake jolle numero laitetaan
     */
    public void setCell(int x, int row, int column) {
        board[row][column] = x;
    }
     
    /**
     * palauttaa laatikon sisältämän numeron
     * @param row rivi
     * @param column sarake
     * @return numero
     */
    public int getCell(int row, int column) {
        return board[row][column];
    }
    
    public int[][] getBoard() {
        return board;
    }
    public int[][] getAnswer() {
        return answer;
    }
    public void setAnswer() {
        solve();
        board = answer;
    }
    
    /**
     * generoi uuden sudokupeliasetelman
     */
    public void generateBoard() {
        BoardGenerator g = new BoardGenerator();
        board = g.generateFromFileRandom();
        answer = board;
    }
    
    /**
     * ratkaisee sudokun
     */
    public void solve() {
        BoardSolver ratkaisija = new BoardSolver();
        answer = ratkaisija.answer(answer);
        //board = answer;
    }
    
    /**
     * antaa vihjeen
     * @param row rivi
     * @param column sarake
     * @return vihje
     */
    public int hint(int row, int column) {
        solve();
        return answer[row][column];
    }
    
    @Override
    public String toString() {
        return Arrays.toString(board);
    }

    public boolean equals(Board board2) {
        if (Arrays.deepEquals(board2.getBoard(), board) ) {
            return true;
        }
        return false;
    }    
}

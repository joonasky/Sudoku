/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

/**
 *
 * @author joonaskylliainen
 */
import java.util.Scanner;

public class KayttoLiittyma {
    
//    public KayttoLiittyma() {
//        
//    }
    public void start() {
        System.out.println("Uusi peli 1, ratkaise sudoku 2");
        Scanner lukija = new Scanner(System.in);
        int luku = lukija.nextInt();
        if (luku == 1) {
            game();
        }
        else if (luku == 2) {
            solution();
        }
                
        
    }
    public static void solution() {
        System.out.println("Anna sudoku");
        Scanner lukija = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = lukija.nextInt();
            }
        }
        BoardSolver ratkaisija = new BoardSolver();
        sudoku = ratkaisija.answer(sudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println("");
        }
    }
    public static void game() {
        Board b = new Board();
        b.generateBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(b.getCell(i, j));              
            }
            System.out.println("");
        }
        b.generateBoard();
        System.out.println("--------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(b.getCell(i, j));              
            }
            System.out.println("");
        }
        
        b.generateBoard();
        System.out.println("--------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(b.getCell(i, j));              
            }
            System.out.println("");
        }
//        System.out.println("");
//        System.out.println("");
//        b.solve();
//        int[][] s = b.getAnswer();
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(s[i][j]);              
//            }
//            System.out.println("");
//        }
        
    }
    
    
    
}

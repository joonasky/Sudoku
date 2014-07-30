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
import java.util.Arrays;


public class RatkaisijaAlgoritmi {



    public static void ratkaise(int[][] sudoku) {
        // Toteuta minut
        try{
        putNumber(sudoku,0,0);
        }catch( Exception e){}
        
        
    }
    public static void putNumber(int[][] sudoku, int row, int column) throws Exception{
//        if (check(sudoku, row, column) == false) {
//            return;
//        }
        if (row > 8) {
            throw new Exception("sienikastiketta!");
        }
        
        if (sudoku[row][column] != 0) {
            if (column < 8) {
                putNumber(sudoku, row, column+1);
            }else{
                putNumber(sudoku, row+1, 0);
            }
        }else {
            for (int x = 1;x<10;x++) {
                if (check(sudoku, row, column, x) == true) {
                    sudoku[row][column] = x;
                    if (column < 8) {
                        putNumber(sudoku, row, column+1);
                    }
                    else {
                        putNumber(sudoku, row+1, 0);
                    }
                }
                
            }
            sudoku[row][column] = 0 ;
        }    
    }
    public static boolean check(int[][] sudoku, int row, int column, int number) {
        if (checkRow(sudoku, row, number) == true && checkColumn(sudoku, column, number) == true && checkBox(sudoku,row,column,number) == true) {
            return true;
        }
        return false;
    }

    public static boolean checkRow(int[][] sudoku, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkColumn(int[][] sudoku, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == number) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkBox(int[][] sudoku, int row, int column, int number) {
        row = (row / 3) * 3 ;
        column = (column / 3) * 3 ;
        
        for( int r = 0; r < 3; r++ ) {
            for( int c = 0; c < 3; c++ ) {             
                if( sudoku[row+r][column+c] == number ) {
                    return false ;
                }
            }    
        }
      return true ;
    }
    
    

//     private static String[] esim1 = new String[]{
//            "??53?????",
//          "8??????2?",
//          "?7??1?5??",
//          "4????53??",
//          "?1??7???6",
//          "??32???8?",
//          "?6?5????9",
//          "??4????3?",
//          "?????97??"};
//
//    public static void main(String[] args) {
//        int[][] sudoku = new int[9][9];
//       
//        sudoku = toIntArray(esim1);
//
//        ratkaise(sudoku);
//
//        System.out.println("Ratkaisu:");
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(sudoku[i][j]);
//            }
//            System.out.println();
//        }
//
//    }
//
//    public static int[][] toIntArray(String[] rs) {
//        int[][] s = new int[9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (rs[i].charAt(j) != '?') {
//                    s[i][j] = Character.digit(rs[i].charAt(j), 10);
//                }
//            }
//        }
//        return s;
//    }
    
    
}

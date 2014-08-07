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
    
    public void KayttoLiittyma() {
        
    }
    public static void start() {
        System.out.println("Uusi peli 1, ratkaise sudoku 2");
        Scanner lukija = new Scanner(System.in);
        int luku = lukija.nextInt();
        if (luku == 1) {
            System.out.println("ei valmis vielä");
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
        RatkaisijaAlgoritmi ratkaisija = new RatkaisijaAlgoritmi();
        sudoku = ratkaisija.vastaus(sudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    
}

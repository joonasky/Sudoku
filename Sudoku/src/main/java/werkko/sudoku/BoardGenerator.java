/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

/**
 *
 * @author joonaskylliainen
 */
import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Luokan tarkoitus on generoida uusi sudoku-peli. Nyt luokka lukee pelin tiedostosta,
 * mutta luokkaa voidaan laajentaa generoimaan pelejä tyhjästä.
 * 
 * @author joonaskylliainen
 */
public class BoardGenerator {
    
    private Random rand;
    /**
     * lukee tiedostosta valmiin sudokun ja palauttaa sen
     * @return sudoku
     */
    public BoardGenerator() {
        this.rand = new Random();
    }
    
    /**
     * Tekee tiedostosta olevasta sudokusta int[][]-taulukon
     * @return
     */
    public int[][] generateFromFile() {
        int[][] sudoku = new int[9][9];
        String[] s = new String[9];
        try {
            File file = new File("src/main/java/werkko/sudoku/sudokut.txt");
            Scanner in = new Scanner(file);
            
            for( int r = 0; r < 9; r++ ) {
                s[r] = in.nextLine();
            }            
            in.close();
        }
        
        catch(Exception e) {
            System.out.println(e.getMessage());
            return sudoku;
        }
            
        return toIntArray(s);
        
    }
    
    /**
     * Arpoo satunnaisen luvun, jonka mukaan valistsee sudokut2.txt-tiedostosta valmiin sudokun
     * ja tekee siitä int[][]-taulukon.
     * @return int[][]-taulukko
     */
    public int[][] generateFromFileRandom() {
        int[][] sudoku = new int[9][9];
        String[] s = new String[9];
        try {
            File file = new File("src/main/java/werkko/sudoku/sudokut2.txt");
            Scanner in = new Scanner(file);
            int ran = rand.nextInt(5);
            for (int i = 0; i <(ran*10); i++) {
                in.nextLine();
            }
            for( int r = 0; r < 9; r++ ) {
                s[r] = in.nextLine();
            }            
            in.close();
        }
        
        catch(Exception e) {
            System.out.println(e.getMessage());
            return sudoku;
        }
            
        return toIntArray(s);
        
    }
    
    /**
     * muuttaa String[]-taulukon int[]-talukoksi. Helpottaa sudokujen käsittelyä.
     * @param rs String[]-taulukko
     * @return int[][]-taulukko
     */
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
}

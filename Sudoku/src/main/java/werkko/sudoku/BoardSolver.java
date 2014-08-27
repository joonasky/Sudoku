/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werkko.sudoku;

/**
 * Luokka sudokun ratkaisemista varten. Algoritmi ratkaisee sudokun Brute force-menetelmällä.
 * 
 * @author joonaskylliainen
 */
public class BoardSolver {
    
    /**
     * palauttaa ratkaistun sudokun, kutsumalla solve-metodia.
     * @param sudoku ratkaistu sudoku
     */
    public int[][] answer(int[][] sudoku) {
        solve(sudoku);
        return sudoku;
    }
    
    /**
     * kutsuu putNumber-metodia sudokun ratkaisemista varten.
     * @param sudoku ratkaistava sudoku
     */
    public static void solve(int[][] sudoku) {
        
        try{
        putNumber(sudoku,0,0);
        }catch( Exception e){}
        
        
    }
    /**
     * Kokeilee sopiiko numero soluun. Jos numero sopii, kutsuu metodi itseään rekursiivisesti ja
     * kokeilee seuraavaan soluun numeroita. 
     * 
     * @param sudoku sudoku, jota ratkaistaan
     * @param row rivi johon kokeillaan numeroa
     * @param column sarake johon kokeillaan numeroa
     * @throws Exception
     */
    public static void putNumber(int[][] sudoku, int row, int column) throws Exception{

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
    /**
     * Tarkistaa sopiiko annettu numero annetuun soluun
     * 
     * @param sudoku sudoku jota tarkistetaan
     * @param row rivi johon numeroa ollaan laittamassa
     * @param column sarake johon numeroa ollaan laittamassa
     * @param number numero jota kokeillaan
     * @return true jos sopii, false jos ei
     */
    public static boolean check(int[][] sudoku, int row, int column, int number) {
        if (checkRow(sudoku, row, number) == true && checkColumn(sudoku, column, number) == true && checkBox(sudoku,row,column,number) == true) {
            return true;
        }
        return false;
    }

    /**
     * Kokeilee sopiiko numeron annettuun riviin
     * 
     * @param sudoku sudoku jota tarkistetaan
     * @param row rivi johon numeroa ollaan laittamassa
     * @param number numero jota kokeillaan
     * @return true jos sopii, false jos ei
     */
    public static boolean checkRow(int[][] sudoku, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return false;
            }
        }
        return true;
    }
    /**
     * Kokeilee sopiiko numeron annettuun sarakkeeseen
     * 
     * @param sudoku sudoku jota tarkistetaan
     * @param column sarake johon numeroa ollaan laittamassa
     * @param number numero jota kokeillaan
     * @return true jos sopii, false jos ei
     */
    public static boolean checkColumn(int[][] sudoku, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == number) {
                return false;
            }
        }
        return true;
    }
    /**
     * Kokeilee sopiiko numeron annettuun laatikkoon
     * 
     * @param sudoku sudoku jota ollaan ratkaisemassa
     * @param row rivi jota kokeillaan
     * @param column sarake jota kokeillaan
     * @param number numero jota kokeillaan
     * @return true jos sopii false jos ei
     */
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
}

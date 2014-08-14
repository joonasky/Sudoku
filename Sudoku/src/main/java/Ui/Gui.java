/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

/**
 *
 * @author joonaskylliainen
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
import werkko.sudoku.Board;
import werkko.sudoku.BoardSolver;

public class Gui implements Runnable{
    
    private JFrame frame;
    
//    public Gui() {
//        
//    }
    
    @Override
    public void run() {
        frame = new JFrame("SUDOKU");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        Board b = new Board();
        //GridBagLayout layout = new GridBagLayout();
        
        SudokuComponent sudoku = new SudokuComponent(b);
        
        container.add(sudoku);
        container.add(luoValikko(), BorderLayout.SOUTH);
        
    }
    
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JButton("Uusi Peli"));
        panel.add(new JButton("Vihje"));
        panel.add(new JButton("Ratkaise"));
        return panel;
    }
    
    
    public void start() {
        System.out.println("**********");
        System.out.println("SUDOKUPELI");
        System.out.println("**********");
        
        
        System.out.println("Uusi peli 1, ratkaise sudoku 2");
        Scanner lukija = new Scanner(System.in);
        int luku = lukija.nextInt();
        if (luku == 1) {
            newGame();
        }
        else if (luku == 2) {
            solution();
        }
                
        
    }
    
    public void solution() {
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
    public void newGame() {
        Board b = new Board();
        b.generateBoard();
        printSudoku(b);
        b.solve();
        System.out.println("Kirjoita valmis kun olet valmis. Kirjoita rivi ja sarake, johon haluat laittaa numeron");
        Scanner lukija = new Scanner(System.in);
        String input = "";
        while (true) {
            input = lukija.nextLine();
            if (input.equals("valmis")) {
                break;
            }
            System.out.println("rivi:");
            int rivi = lukija.nextInt();
            System.out.println("sarake");
            int sarake = lukija.nextInt();
            if (input.equals("hint")) {
                System.out.println(b.hint(rivi, sarake));               
            }
            if (input.equals("")) {
                System.out.println("numero:");
                int numero = lukija.nextInt();
                b.setCell(numero, rivi, sarake);
            }
            
            printSudoku(b);
            System.out.println("valmis?");
                       
        }
        System.out.println("vastaus:/n");
        int[][] a = b.getAnswer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j]);              
            }
            System.out.println("");
        }
        
        
            
        
//        b.generateBoard();
//        System.out.println("--------");
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(b.getCell(i, j));              
//            }
//            System.out.println("");
//        }
//        
//        b.generateBoard();
//        System.out.println("--------");
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(b.getCell(i, j));              
//            }
//            System.out.println("");
//        }
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
    /**
     * Tulostaa sudokun
     * @param b
     */
    public static void printSudoku(Board b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(b.getCell(i, j));              
            }
            System.out.println("");
        }
    }
    
    
    
}

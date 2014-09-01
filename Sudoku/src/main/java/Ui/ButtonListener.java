/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import werkko.sudoku.Board;

/**
 *
 * @author joonaskylliainen
 */
public class ButtonListener implements ActionListener{
    
    private Board board;
    private int num;
    private Random r1;
    private Random r2;
    private Component sc;
    
    public ButtonListener(Board b, int num, Component sc) {
        this.board = b;
        this.num = num;
        this.sc = sc;
        r1 = new Random();
        r2 = new Random();
    }

    /**
     * Jos buttonListenerilleo on annettu 0 parametrinä, toimii nappi taulun generoijana.
     * Jos 1 toimii se ratkaisijana
     * jos 2 toimii se vihjeenä
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
         switch(num) {
            case 0:
                board.generateBoard();
                sc.repaint();
              break;

            case 1:
                int x = r1.nextInt(9);
                int y = r2.nextInt(9);
                board.setCell(board.hint(x, y), x, y);
                sc.repaint();
              break;

            case 2:
                board.setAnswer();
                sc.repaint();
              break;
                
            case 3:
                board.clear();
                sc.repaint();
              break;
         }       

    }
    
}

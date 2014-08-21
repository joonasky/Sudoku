/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import werkko.sudoku.Board;

/**
 *
 * @author joonaskylliainen
 */
public class ButtonListener implements ActionListener{
    
    private Board board;
    private int num;
    private int r1;
    private int r2;
    private Component sc;
    
    public ButtonListener(Board b, int num, Component sc) {
        this.board = b;
        this.num = num;
        this.sc = sc;
        r1 = (int) Math.random()*10;
        r2 = (int) Math.random()*10;
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
                board.solve();
                sc.repaint();
              break;

            case 2:
                board.setCell(board.hint(r1, r2), r1, r2);
                sc.repaint();
              break;
         }       

    }
    
}

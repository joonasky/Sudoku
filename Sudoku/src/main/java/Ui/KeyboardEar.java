/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import werkko.sudoku.Board;

/**
 *
 * @author joonaskylliainen
 */
public class KeyboardEar implements KeyListener{
    
    private SudokuComponent sc;
    private Board b;
    
    public KeyboardEar(Board b, SudokuComponent sc) {
        this.sc = sc;
        this.b = b;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(b.isThereAnActiveField()) {
            char c = ke.getKeyChar();
            int num = Character.getNumericValue(c);
            b.setCell(num, b.getActiveFieldx(), b.getActiveFieldy());
            b.deActivate();
            sc.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //System.out.println("novittu");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}

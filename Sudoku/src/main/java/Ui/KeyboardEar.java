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
            if(num <= 9 && num >= 0) {
                b.setCell(num, b.getActiveFieldx(), b.getActiveFieldy());
            }
            b.deActivate();
            sc.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if(b.getActiveFieldx() != 0) {
                b.activate(b.getActiveFieldx() - 1, b.getActiveFieldy());
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(b.getActiveFieldx() != 8) {
                b.activate(b.getActiveFieldx() + 1, b.getActiveFieldy());
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            if(b.getActiveFieldy() != 0) {
                b.activate(b.getActiveFieldx(), b.getActiveFieldy() - 1);
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            if(b.getActiveFieldy() != 8 ) {
                b.activate(b.getActiveFieldx(), b.getActiveFieldy() + 1);
            }
        }

        sc.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}

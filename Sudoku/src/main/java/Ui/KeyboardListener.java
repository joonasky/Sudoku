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
public class KeyboardListener implements KeyListener{
    
    private SudokuComponent sc;
    
    public KeyboardListener(SudokuComponent sc) {
        this.sc = sc;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

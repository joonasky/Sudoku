/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import werkko.sudoku.Board;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author joonaskylliainen
 */
public class SudokuComponent extends JPanel{

    private Board board;
    
    SudokuComponent (Board b) {
        super();
        board = b; 
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        
        g.draw3DRect(0, 0, 180, 60, true);
        g.draw3DRect(0, 60, 180, 60, true);
        g.draw3DRect(0, 120, 180, 60, true);
        g.draw3DRect(60, 0, 60, 180, true);
        

        
    }
    
    public void paivita() {
        repaint();
    }
}

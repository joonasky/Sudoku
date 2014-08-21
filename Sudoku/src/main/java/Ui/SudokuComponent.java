/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import werkko.sudoku.Board;

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
    
    /**
     * Piirtää sudokulaudan ja numerot
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        
        
        
        //piirtää isot neliöt
        g.drawRect(0, 0, 540, 180);
        g.drawRect(0, 180, 540, 180);
        g.drawRect(0, 360, 540, 180);
        g.drawRect(180, 0, 180, 540);
        
        //vahventaa isoja neliöitä
        g.drawRect(1, 1, 540, 180);
        g.drawRect(1, 181, 540, 180);
        g.drawRect(1, 361, 540, 180);
        g.drawRect(181, 1, 180, 540);
        
        //vahventaa lisää isoja neliöitä
        g.drawRect(2, 2, 540, 180);
        g.drawRect(2, 182, 540, 180);
        g.drawRect(2, 362, 540, 180);
        g.drawRect(182, 2, 180, 540);
        
        //piirtää pienet neliöt
        g.drawRect(60, 0, 60, 540);
        g.drawRect(0, 60, 540, 60);
        
        g.drawRect(240, 0, 60, 540);
        g.drawRect(0, 240, 540, 60);
        
        g.drawRect(420, 0, 60, 540);
        g.drawRect(0, 420, 540, 60);
        
        int i2 = 28;
        for (int i = 0; i<9; i++) {         
            int j2 = 34;
            for (int j = 0; j<9;j++) {              
                g.drawString(cellToString(i,j), i2, j2);
                j2 += 60;
            }
            i2 += 60;
        }
        
        
        
    }
    
    public void paivita() {
        repaint();
    }
    /**
     * tekee solun numerosta stringin.
     * @param r
     * @param c
     * @return
     */
    public String cellToString(int r, int c) {
        int x = board.getCell(r, c);
        if(x != 0) {
            String  s = Integer.toString(x);
            return s;
        }else {
            return "";
        }
    }
}

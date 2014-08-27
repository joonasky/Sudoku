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
    
    private final int length = 540;
    private final int bigBoxLength = 180;
    private final int smallBoxLength = 60;
    
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
        
        // piirtää isot laatikot
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                g.drawRect(x*bigBoxLength, y*bigBoxLength, bigBoxLength, bigBoxLength);
                g.drawRect(x*bigBoxLength + 1, y*bigBoxLength + 1, bigBoxLength, bigBoxLength);
                g.drawRect(x*bigBoxLength + 2, y*bigBoxLength + 2, bigBoxLength, bigBoxLength);
            }
        }
        
        //piirtää pienet laatikot
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                g.drawRect(x * smallBoxLength, y * smallBoxLength, smallBoxLength, smallBoxLength);
            }
        }
        
        //piirtää numerot
        //int i2 = 28;
        for (int i = 0; i<9; i++) {         
            //int j2 = 34;
            for (int j = 0; j<9;j++) {              
                g.drawString(cellToString(i,j), 28 + i*60, 34 + j*60);
                //j2 += 60;
            }
            //i2 += 60;
        }
        
        //värittää valitun kentän
        if(board.isThereAnActiveField()) {
            int x = board.getActiveFieldx();
            int y = board.getActiveFieldy();
            g.setColor(Color.ORANGE);
            g.drawRect(x * 60 , y * 60, smallBoxLength, smallBoxLength);
            
            //g.drawString(cellToString(x,y), 28 + x*60, 34 + y*60);
            g.setColor(Color.black);
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

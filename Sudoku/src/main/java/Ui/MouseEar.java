/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import werkko.sudoku.Board;

/**
 * Hiirenkuuntelija
 * @author joonaskylliainen
 */
public class MouseEar implements MouseListener, MouseMotionListener{
    
    private Component component;
    private Board b;
    
    public MouseEar(Board b, Component component) {
        this.component = component;
        this.b = b;
    }

    /**
     * Kun jotain aluetta painetaan niin katsotaan millä alueella se oli ja aktivoidaan sen mukainen solu.
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        b.activate((int)Math.ceil(me.getX() / 60), (int)Math.ceil(me.getY()) / 60);
        component.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
}

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

/**
 *
 * @author joonaskylliainen
 */
public class HiirenKuuntelija implements MouseListener, MouseMotionListener{
    
    private Component component;
    
    public HiirenKuuntelija(Component component) {
        this.component = component;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Point point = me.getPoint();
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
        //System.out.println("mouse moved (" + me.getX() + ", " + me.getY() + ")");
    }
    
}

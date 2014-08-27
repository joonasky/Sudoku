/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

/**
 *
 * @author joonaskylliainen
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import werkko.sudoku.Board;

public class Gui implements Runnable {

    private JFrame frame;
    private Board b;

    public Gui(Board b) {
        this.b = b;
    }

    @Override
    public void run() {
        frame = new JFrame("SUDOKU");
        frame.setPreferredSize(new Dimension(560, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        SudokuComponent sudoku = new SudokuComponent(b);

        MouseEar hiiri = new MouseEar(b,sudoku);

        sudoku.addMouseListener(hiiri);
        sudoku.addMouseMotionListener(hiiri);

        container.add(sudoku);
        container.add(createButtons(b, sudoku), BorderLayout.SOUTH);
        
        KeyboardEar nappis = new KeyboardEar(b,sudoku);
        frame.addKeyListener(nappis);
        
    }

    private JPanel createButtons(Board b, SudokuComponent sc) {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton uusi = new JButton("Uusi Peli");
        JButton vihje = new JButton("Vihje");
        JButton ratkaise = new JButton("Ratkaise");

        uusi.addActionListener(new ButtonListener(b, 0, sc));
        vihje.addActionListener(new ButtonListener(b, 1, sc));
        ratkaise.addActionListener(new ButtonListener(b, 2, sc));
        
        uusi.setFocusable(false);
        vihje.setFocusable(false);
        ratkaise.setFocusable(false);

        panel.add(uusi);
        panel.add(vihje);
        panel.add(ratkaise);

        return panel;
    }
    
     public JFrame getFrame() {
        return frame;
    }
}


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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        frame.setPreferredSize(new Dimension(560, 630));
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

    private JPanel createButtons(final Board b, SudokuComponent sc) {
        JPanel panel = new JPanel(new GridLayout(2, 3));

        JButton uusi = new JButton("Uusi Peli");
        JButton vihje = new JButton("Vihje");
        JButton ratkaise = new JButton("Ratkaise");
        JButton uusityhja = new JButton("Uusi tyhjä peli");
        JButton tarkasta = new JButton("Tarkasta");

        uusi.addActionListener(new ButtonListener(b, 0, sc));
        vihje.addActionListener(new ButtonListener(b, 1, sc));
        ratkaise.addActionListener(new ButtonListener(b, 2, sc));
        uusityhja.addActionListener(new ButtonListener(b,3,sc));
        tarkasta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(b.checkIfFinished()) {
                    JOptionPane.showMessageDialog(frame, "Oikea vastaus!", "JEE!!", JOptionPane.PLAIN_MESSAGE);
                }
            }  
        });
        
        uusi.setFocusable(false);
        vihje.setFocusable(false);
        ratkaise.setFocusable(false);
        uusityhja.setFocusable(false);
        tarkasta.setFocusable(false);

        panel.add(uusi);
        panel.add(vihje);
        panel.add(ratkaise);
        panel.add(uusityhja);
        panel.add(tarkasta);

        return panel;
    }
    
     public JFrame getFrame() {
        return frame;
    }
}


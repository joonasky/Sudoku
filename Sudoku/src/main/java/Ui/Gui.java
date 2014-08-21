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

//    public Gui() {
//        
//    }
    public Gui(Board b) {
        this.b = b;
    }

    @Override
    public void run() {
        frame = new JFrame("SUDOKU");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        //Board b = new Board();
        //GridBagLayout layout = new GridBagLayout();


        SudokuComponent sudoku = new SudokuComponent(b);

        HiirenKuuntelija hiiri = new HiirenKuuntelija(sudoku);
        KeyboardListener nappis = new KeyboardListener(sudoku);

        sudoku.addMouseListener(hiiri);
        sudoku.addMouseMotionListener(hiiri);

        container.add(sudoku);
        container.add(createButtons(b, sudoku), BorderLayout.SOUTH);

    }

    private JPanel createButtons(Board b, SudokuComponent sc) {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton uusi = new JButton("Uusi Peli");
        JButton vihje = new JButton("Vihje");
        JButton ratkaise = new JButton("Ratkaise");

        ButtonListener kuuntelija = new ButtonListener(b, 0, sc);
        uusi.addActionListener(kuuntelija);
        vihje.addActionListener(new ButtonListener(b, 1, sc));
        ratkaise.addActionListener(new ButtonListener(b, 2, sc));

        panel.add(uusi);
        panel.add(vihje);
        panel.add(ratkaise);



        return panel;
    }
}


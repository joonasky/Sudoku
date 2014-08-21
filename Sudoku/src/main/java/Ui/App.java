package Ui;

/**
 * Hello world!
 *
 */

import javax.swing.SwingUtilities;
import werkko.sudoku.Board;

public class App 
{
    public static void main( String[] args )
    {
        Gui kayttis = new Gui(new Board());
        SwingUtilities.invokeLater(kayttis);
        //kayttis.start();
    }
}

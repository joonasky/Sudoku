package Ui;

/**
 * Hello world!
 *
 */

import javax.swing.SwingUtilities;

public class App 
{
    public static void main( String[] args )
    {
        Gui kayttis = new Gui();
        SwingUtilities.invokeLater(kayttis);
        //kayttis.start();
    }
}

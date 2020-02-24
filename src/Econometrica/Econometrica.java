package Econometrica;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import GuiDesign.MainForm;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Econometrica {
    
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //εμφάνιση του κεντρικού μενου
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true);
            }
        });
    }   
}
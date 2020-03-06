/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica_priv;

import econometrica_GUI.MainForm;
import java.io.FileNotFoundException;
import java.text.ParseException;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author vborotis
 */
public class Econometrica_priv {


   public static void main(String[] args) throws ParseException, FileNotFoundException {
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //εμφάνιση του κεντρικού μενου
                MainForm mainForm = new MainForm();
                RefineryUtilities.centerFrameOnScreen(mainForm);
                mainForm.setVisible(true);
            }
        });
    }
}


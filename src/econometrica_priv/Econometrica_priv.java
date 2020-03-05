/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica_priv;

import Connections.DBManager;
import econometrica_GUI.MainFrame;
import java.sql.SQLException;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author vborotis
 */
public class Econometrica_priv {


    final String msg = new String();
    protected static EntityManager em;
    protected static DBManager dbm;
    
    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, SQLException {
        // TODO code application logic here
    
        // Διαδικασία Σύνδεσης με την Βάση Δεδομένων για όλη 
        // την διάρκεια εκτέλεσης της Εφαρμογής
//    if (em == null)
//        {
//            //ΚΛΗΣΗ FINAL CLASS DbConnectHelper ΓΙΑ ΣΥΝΔΕΣΗ ΣΤΗ ΒΑΣΗ
//            //ΚΑΙ ΔΗΜΙΟΥΡΓΙΑ entity factory ΚΑΙ entity manager
//            DBManager.connect();
//            em = DBManager.getEm();
//        }

    MainFrame mf = new MainFrame();
    mf.setVisible(true);
    mf.pack();
    RefineryUtilities.centerFrameOnScreen(mf);
    mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

    }
}


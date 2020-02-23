/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */
public class DBConnection {
    
    private static final String PERSISTENCE_UNIT_NAME = "EconometricaPU";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void connect() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                em = emf.createEntityManager();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Δεν ήταν δυνατή η σύνδεση με τη Βάση Δεδομένων", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static EntityManager getEm() {
        return em;
    }
}



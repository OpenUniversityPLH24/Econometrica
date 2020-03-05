/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author vborotis
 */
public class DBManager {

    private static final String PERSISTENCE_UNIT_NAME = "EconometricaPU";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String DB_URL = "jdbc:derby://localhost:1527/Econometrica;Connect=true";
    private static final String USER = "ergasia3";
    private static final String PASS = "ergasia3";
//    "org.apache.derby.jdbc.ClientDriver"
    private static EntityManagerFactory emf; 
    private static EntityManager em;
    
    /**
     * @return the emf
     */
    
    public DBManager() {  
        try {
            //Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex); 
        }
    }
        
        public static void connection() {
//        try{
//         //ΜΕΤΑΒΛΗΤΗ ΤΥΠΟΥ Connection ΣΤΗΝ ΟΠΟΙΑ ΚΑΤΑΧΩΡΕΙΤΕ ΤΟ CONNECTION STRING           
//        Connection conn = DriverManager.getConnection(DB_URL , USER , PASS);
//        } catch(SQLException ex){ //
//            //Handle errors for JDBC
//            ex.printStackTrace();
//            System.out.println(ex.getMessage());
//            //ΣΦΑΛΜΑ ΑΠΟΤΥΧΙΑΣ ΣΥΝΔΕΣΗΣ
//            if (ex.getSQLState().toUpperCase().equals("08001".toUpperCase())) {
//                 //ΜΗΝΥΜΑ ΣΦΑΛΜΑΤΟΣ ΣΥΝΔΕΣΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ
//                JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τη Βάση Δεδομένων. Έλέγξτε αν ο Server της JavaDB είναι φορτωμένος.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
//                //ΚΑΤΑΧΩΡΗΣΗ ΣΤΗ ΜΕΤΑΒΛΗΤΗ ΣΦΑΛΜΑΤΟΣ ΓΙΑ ΣΦΑΛΜΑ
////                err = true;
//            }           
//        }
//          
//          
////        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
////        em = emf.createEntityManager();
//        // από εδώ αρχίζουν τα transactions
//        
////        em.close();
////        emf.close();
    }  
    
    //ΔΑΙΔΙΚΑΣΙΑ ΣΥΝΔΕΣΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ 
    public static void connect() throws SQLException
    {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = null;
//        String sql = "";
        //if (emf == null)
        //{
            try {
                //ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ Entity Manager ΓΙΑ ΤΗ ΣΥΝΔΕΣΗ ΤΗΣ ΕΦΑΡΜΟΓΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ.
                stmt = conn.createStatement();
//                System.out.println("stmt = " + stmt);
//                stmt.execute(sql); 
//                System.out.println("SQL = " + stmt.execute(sql));
            }
            catch(Exception exc)
            {
                System.out.println(exc); 
                //ΜΗΝΥΜΑ ΣΦΑΛΜΑΤΟΣ ΣΥΝΔΕΣΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ
                JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τη Βάση Δεδομένων. Έλέγξτε αν ο Server της JavaDB είναι φορτωμένος.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
            
            try 
            {

                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                em = emf.createEntityManager(); 
            } 
            catch(Exception ex) 
            {
                System.out.println(ex); 
                //ΜΗΝΥΜΑ ΣΦΑΛΜΑΤΟΣ ΣΥΝΔΕΣΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ
                JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τη Βάση Δεδομένων. Έλέγξτε αν ο Server της JavaDB είναι φορτωμένος.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
        //}
    }
    
    /**
     * @return the emf
     */
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @return the em
     */
    public static EntityManager getEm() {
        return em;
    }
    
    public static void disconnect()
    {
        //if (emf == null)
        //{
            try 
            {
                //ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ Entity Manager ΓΙΑ ΤΗ ΣΥΝΔΕΣΗ ΤΗΣ ΕΦΑΡΜΟΓΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ.
                
                if (emf.isOpen()==true) 
                    emf.close();
                System.out.println("Αποσυνδέθηκε από την βάση δεδομένων");
            } 
            catch(Exception ex) 
            {
                System.out.println(ex); 
                //ΜΗΝΥΜΑ ΣΦΑΛΜΑΤΟΣ ΣΥΝΔΕΣΗΣ ΜΕ ΤΗΝ ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ
                JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τη Βάση Δεδομένων. Έλέγξτε αν ο Server της JavaDB είναι φορτωμένος.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
        //}
    }    
}

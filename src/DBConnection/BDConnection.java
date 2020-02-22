package DBConnection;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class BDConnection {

    //Η κλάση αυτή περιέχει τη μέθοδο για τη σύνδεση στη βάση
    //και τη δημιουργία του Entity Manager που θα χρησιμοποιηθεί καθ όλη τη διάρκεια εκτέλεσης της εφαρμογής.
    public final class connect{

        private static final String PERSISTENCE_UNIT_NAME = "EconometricaPU";
        private EntityManagerFactory emf;
        private EntityManager em;

        public void connect() {
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

        public EntityManager getEm() {
            return em;
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBConnection;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnection {

    public void saveQuery(String query) throws SQLException, ClassNotFoundException {

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String server = "jdbc:derby://localhost:1527/Econometrica";
        String user = "ergasia3";
        String pass = "ergasia3";

        try (Connection conn = DriverManager.getConnection(server,user,pass)) {
            ResultSet rs;
            try (Statement state = conn.createStatement()) {
                rs = state.executeQuery(query);
                //while(rs.next()){
                //    System.out.println(rs.getInt(1)+" "+rs.getString(2));
                //}
                conn.close();
                state.close();
            }
            rs.close();
        }
    }
}
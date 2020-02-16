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

    public void executeQuery(String query) throws SQLException {
        String server = "jdbc:derby://localhost:1527/Econometrica [ergasia3 on ERGASIA3]";
        String user = "ergasia3";
        String pass = "ergasia3";
        
        try (Connection conn = DriverManager.getConnection(server,user,pass)) {
            Statement state = conn.createStatement();
            ResultSet rs=state.executeQuery(query);
            
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));  
            }
            conn.close();
            state.close();
            rs.close();
        }
    }
}
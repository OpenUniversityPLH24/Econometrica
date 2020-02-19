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

import Econometrica.AllData;
import Econometrica.Country;
import Econometrica.CountryData;
import Econometrica.CountryDataset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnectionFetch {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:derby://localhost/Econometrica";

    //  Database credentials
    static final String USER = "ergasia3";
    static final String PASS = "ergasia3";

    public AllData openConnection(String sql) throws SQLException, ClassNotFoundException {

    Connection conn = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
    Country country = new Country();
    CountryData countrydata = new CountryData();
    CountryDataset countrydataset = new CountryDataset();
    AllData alldatavalues = new AllData(country, countrydata , countrydataset);
    try{
        
        System.out.println("Connecting to try...");
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        //Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        if (conn != null) {
            System.out.println("Connected to the database");
        }

        //Execute a query
        System.out.println("Creating statement...");
        stmt1 = conn.createStatement();
        stmt2 = conn.createStatement();
        System.out.println("Completed statement...");
        //Extract data from result set
        
        try (ResultSet rs = stmt1.executeQuery(sql)) {
        //Extract data from Result Set
        while (rs.next()) {            
            String iso_code  = rs.getString("ISO_CODE");
            country.setIsoCode(iso_code);
            String name = rs.getString("NAME");
            country.setName(name);
            String start_date = rs.getString("START_YEAR");
            countrydataset.setStartYear(start_date);
            //String start_date_final = start_date.substring(0, 4);
            String end_date = rs.getString("END_YEAR");
            countrydataset.setEndYear(end_date);
            //String end_date_final = end_date.substring(0, 4);
                    
            //Display values
            System.out.print("ISO_CODE: " + iso_code);
            System.out.print(", NAME: " + name);
            System.out.print(", START YEAR: " + start_date);
            System.out.print(", END YEAR: " + end_date+ "\n");
                //Retrieve by column name
            }
        }

                try (ResultSet rs2 = stmt2.executeQuery(sql)) {
        //Extract data from Result Set

            while (rs2.next()) { 

                //Retrieve by column name
                String data_year  = rs2.getString("DATA_YEAR");
                countrydata.setDataYear(data_year);
                String value = rs2.getString("VALUE");
                countrydata.setValue(value);
                        
                //Display values
                System.out.print("YEAR: " + data_year);
                System.out.print(", VALUE: " + value + "\n");
            }
            //Clean-up environment
        }
        stmt1.close();
        stmt2.close();
        conn.close();
    }catch(SQLException se){
        //Handle errors for JDBC
        System.out.println(se);
    }
    finally{
    //finally block used to close resources
        try{
            if(stmt1!=null)
                stmt1.close();
            }catch(SQLException se2){
        }// nothing we can do
        try{
            if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
            conn.close();
        }catch(SQLException se){
            }//end finally try
        }//end try
    return alldatavalues;
    }
//end main
}//end FirstExample
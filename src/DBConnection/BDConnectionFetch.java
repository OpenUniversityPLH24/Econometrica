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
import java.util.ArrayList;
import java.util.List;

public class BDConnectionFetch {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:derby://localhost/Econometrica";

    //  Database credentials
    static final String USER = "ergasia3";
    static final String PASS = "ergasia3";

    public AllData openConnection(String sql) throws SQLException, ClassNotFoundException {

    Connection conn = null;
    Statement stmt = null;
    Country country = new Country();
    List<CountryData> countrydata = new ArrayList<>();
    CountryDataset countrydataset = new CountryDataset();
    AllData alldatavalues = new AllData(country, countrydata, countrydataset);
    try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        //Open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        if (conn != null) {
            System.out.println("Connected to the database");
        }

        //Execute a query
        stmt = conn.createStatement();
        
        //Extract data from result set        
        try (ResultSet rs = stmt.executeQuery(sql)) {
        //Extract data from Result Set
        
        while (rs.next()) {
            String iso_code  = rs.getString("ISO_CODE");
            country.setIsoCode(iso_code);
            String name = rs.getString("NAME");
            country.setName(name);
            String description = rs.getString("DESCRIPTION");
            countrydataset.setDescription(description);
            String start_date = rs.getString("START_YEAR");
            countrydataset.setStartYear(start_date);
            String end_date = rs.getString("END_YEAR");
            countrydataset.setEndYear(end_date);

            //Display values
            String data_year  = rs.getString("DATA_YEAR");
            String value = rs.getString("VALUE");
            //Display values
            System.out.print("YEAR: " + data_year);
            System.out.print(", VALUE: " + value + "\n");
            int i=0;
            CountryData a = new CountryData();
            a.setDataYear(data_year);
            a.setValue(value);
            alldatavalues.addCountryData(a);
            System.out.println("Connected to the database 2");
            i++;
            //Retrieve by column name
            }        
        }
        stmt.close();
        conn.close();
        return alldatavalues;
    }catch(SQLException se){
        //Handle errors for JDBC
        System.out.println(se);
    }
    finally{
    //finally block used to close resources
        try{
            if(stmt!=null)
                stmt.close();
            }catch(SQLException se2){
        }
        try{
            if(conn!=null)
            conn.close();
        }catch(SQLException se){
            }//end finally try
        }//end try
        return null;    
    }    
}
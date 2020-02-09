/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Econometrica;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

public class Econometrica {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println(jsonGetRequest("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=j79mQ_zEuVUqFV1DihJT"));
    System.out.println(jsonGetRequest("https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json?api_key=j79mQ_zEuVUqFV1DihJT"));
    }
    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }

    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    return json;
    }
}
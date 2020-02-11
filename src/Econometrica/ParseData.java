/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Econometrica;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseData {
    
    public void parseData(String response) throws ParseException, MalformedURLException, IOException {
        System.out.println(response);
        //JSONParser parser = new JSONParser();
        //Object obj = parser.parse(response);
        //JSONObject jsonObject = (JSONObject) obj;
        //η κλάση InputStream μετατρέπει τα δεδομένα σε μια διατεταγμένη σειρα απο bytes
        URL url = new URL(response);
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        //JsonElement ειναι για να πάρουμε κάθε φορά τα στοιχεία απο json αρχειο
        JsonElement jElement = new JsonParser().parse(isr);
        //και το μετατρέπουμε σε αντικέιμενο για να το διαχειριστούμε
        JsonObject mainJsonObject = jElement.getAsJsonObject();
        
        JsonObject jsonObject;
            //για κάθε αντικέιμενο ελέγχουμε αν είναι αυτό που θέλουμε 
            //και αν είναι φτίαχνουμε ενα αντικέιμενο Genre με το id και το όνομα απο το json
            for (int i = 0; i < mainJsonObject.get("data").getAsJsonArray().size(); i++) {
                    gpd newdata = new gpd(
                    jsonObject.get("dataset_code").,
                    jsonObject.get("name"),
                    jsonObject.get("description"),
                    jsonObject.get("Date"),
                    jsonObject.get("Value")); 
                    }

                
//        JSONArray datalist = (JSONArray) jsonObject.get("data");
//        Iterator iterator = datalist.iterator();
//        while(iterator.hasNext()){
//            System.out.println("Data: "+iterator.next());
//        }
//        gpd newdata = new gpd(
//            (String) jsonObject.get("dataset_code"),
//            (String) jsonObject.get("name"),
//            (String) jsonObject.get("description"),
//            (List<String>) jsonObject.get("Date"),
//            (List<String>) jsonObject.get("Value"));
                
        //System.out.println(jsonObject.getOrDefault("dataset", "0"));
    }
}
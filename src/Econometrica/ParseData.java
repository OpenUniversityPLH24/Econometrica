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
import org.json.simple.parser.ParseException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseData {
    
    public void parseData(String response) throws ParseException, MalformedURLException, IOException {
        System.out.println(response);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        //η κλάση InputStream μετατρέπει τα δεδομένα σε μια διατεταγμένη σειρα απο bytes
                
        JSONArray datalist = (JSONArray) jsonObject.get("data");
 //       Iterator iterator = datalist.iterator();
 //       while(iterator.hasNext()){
 //           System.out.println("Data: "+iterator.next());
 //       }
 //       gpd newdata = new gpd(
 //           (String) jsonObject.get("dataset_code"),
 //           (String) jsonObject.get("name"),
 //           (String) jsonObject.get("description"),
 //           (List<String>) jsonObject.get("Date"),
 //           (List<String>) jsonObject.get("Value"));
                
        //System.out.println(jsonObject.getOrDefault("dataset", "0"));
    }
}
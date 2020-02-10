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

import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseData {
    
    public void parseData(String response) throws ParseException {
        System.out.println(response);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        System.out.println(obj);
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);
        
        gpd newdata = new gpd(
            (String) jsonObject.get("dataset_code"),
            (String) jsonObject.get("name"),
            (String) jsonObject.get("description"),
            (List<String>) jsonObject.get("Date"),
            (List<String>) jsonObject.get("Value"));
        
        //System.out.println(jsonObject.get("dataset_code"));
    }
}
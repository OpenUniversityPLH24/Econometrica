/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vborotis
 */
public class FetchData {

private DataSet Dataset;  

    public void FetchData() {
    }
    
    public FetchData FetchData(String http, String abc) throws ParseException {

// Δημιουργία JsonParser για πέρασμα των δεδομένων από το 
// portal σε αντικείμενα της εφαρμογής
       JsonParser jsonParser = new JsonParser();
// Το jsonTree φιλοξενεί τα δεδομένα σε μορφή δομής.
       JsonElement jsonTree = jsonParser.parse(http);
     
       int indicator = 0;
       
       DataSet gdpset = new DataSet();
// Ελέγχουμε αν το JsonTree είναι ένα json object          
       if (jsonTree.isJsonObject()) { 
           indicator = 1; 
           JsonObject jsonObject = jsonTree.getAsJsonObject();
           JsonElement dataset = jsonObject.get("dataset");
           
           if (dataset.isJsonObject()) {
               
               JsonObject jobj_id = dataset.getAsJsonObject();
               JsonElement id = jobj_id.get("id");
               gdpset.setId(id.getAsInt());
//               System.out.println("id : " + id);
               
               JsonObject jobj_dset = dataset.getAsJsonObject();               
               JsonElement dataset_code = jobj_dset.get("dataset_code");
               gdpset.setDataset_code(dataset_code.getAsString());
//               System.out.println("dataset_code : " + dataset_code);
               
               JsonObject jobj_dbcode = dataset.getAsJsonObject(); 
               JsonElement database_code = jobj_dbcode.get("database_code");
               gdpset.setDatabase_code(database_code.getAsString());
//               System.out.println("database_code : " + database_code);
               
               JsonObject jobj_name = dataset.getAsJsonObject();               
               JsonElement name = jobj_name.get("name");
               gdpset.setName(name.getAsString());
 //              System.out.println("name : " + name);
               
               JsonObject jobj_descr = dataset.getAsJsonObject();                 
               JsonElement description = jobj_descr.get("description");
               gdpset.setDescription(description.getAsString());
//               System.out.println("description : " + description);
               
               JsonObject jobj_rfr_at = dataset.getAsJsonObject();
               JsonElement refreshed_at = jobj_rfr_at.get("refreshed_at");
               gdpset.setRefreshed_at(refreshed_at.getAsString());
//               System.out.println("refreshed_at : " + refreshed_at);
               
               JsonObject jobj_new_dt = dataset.getAsJsonObject();
               JsonElement newest_available_date = jobj_new_dt.get("newest_available_date");
               gdpset.setNewest_available_date(newest_available_date.getAsString());
//               System.out.println("newest_available_date : " + newest_available_date);
               
               JsonObject jobj_old_dt = dataset.getAsJsonObject();
               JsonElement oldest_available_date = jobj_old_dt.get("oldest_available_date");
               gdpset.setOldest_available_date(oldest_available_date.getAsString());
//               System.out.println("oldest_available_date : " + oldest_available_date);
               
               JsonObject jobj_col_nm = dataset.getAsJsonObject();
               JsonElement column_names = jobj_col_nm.get("column_names");
//               System.out.println( "is Json Array ? " + column_names.isJsonArray());
//  Για objects τύπου πίνακες χρειαζόμαστε έναν json reader                  
               JsonReader jsonReader = new JsonReader(new StringReader(jobj_col_nm.get("column_names").toString()));
// Διατρέχουμε το column_names , εντοπίζουμε τις διαφορετικές τιμές και τις περνάμε σε άλλα πεδία  
               JsonArray jsonArray = new JsonArray(); 
               ArrayList lst = new ArrayList();
               try {
                    while(jsonReader.hasNext()){
                    JsonToken nextToken = jsonReader.peek();
//                    System.out.println(nextToken);
                    if(JsonToken.BEGIN_ARRAY.equals(nextToken)){
                       jsonReader.beginArray();
                      } 
                       else 
                    if(JsonToken.NAME.equals(nextToken)){
                       String name1  =  jsonReader.nextName();
//                       System.out.println(name1);
                      } 
                       else 
                    if(JsonToken.STRING.equals(nextToken)){
                       String value =  jsonReader.nextString();
                       lst.add(value);
                       jsonArray.add(value);
//                       System.out.println(value);
                      } 
                       else 
                    if(JsonToken.NUMBER.equals(nextToken)){
                       int value1 =  (int)jsonReader.nextLong();
                       lst.add(value1);
                       jsonArray.add(value1);
//                       System.out.println(value);  
                      }
                    } // end while 
                     gdpset.setColumn_names(lst);
} catch (IOException e) { e.printStackTrace(); }              
//               System.out.println("column_names : " + column_names);   
               
               JsonObject jobj_freq = dataset.getAsJsonObject();
               JsonElement frequency = jobj_freq.get("frequency");
               gdpset.setFrequency(frequency.getAsString());
//               System.out.println("frequency : " + frequency);  

               JsonObject jobj_type = dataset.getAsJsonObject();
               JsonElement type = jobj_type.get("type");
               gdpset.setType(type.getAsString());
//               System.out.println("type : " + type);
               
               JsonObject jobj_prem = dataset.getAsJsonObject();
               JsonElement premium = jobj_prem.get("premium");
               gdpset.setPremium(premium.getAsBoolean());
//               System.out.println("premium : " + premium);
               
               JsonObject jobj_limit = dataset.getAsJsonObject();
               JsonElement limit = jobj_limit.get("limit");
               if (!(limit.isJsonNull())) {
                   gdpset.setLimit(limit.getAsString());
               }
//               System.out.println("limit : " + limit);
               
               JsonObject jobj_trans = dataset.getAsJsonObject();
               JsonElement transform = jobj_trans.get("transform");
               if (!(transform.isJsonNull())) {
                   gdpset.setTransform(transform.getAsString());
               }
//               System.out.println("transform : " + transform);
               
               JsonObject jobj_col_inx = dataset.getAsJsonObject();
               JsonElement column_index = jobj_col_inx.get("column_index");
               if (!(column_index.isJsonNull())) {
                   gdpset.setColumn_index(column_index.getAsString());
               }
//               System.out.println("column_index : " + column_index);
               
               JsonObject jobj_start_dt = dataset.getAsJsonObject();
               JsonElement start_date = jobj_start_dt.get("start_date");
               gdpset.setStart_date(start_date.getAsString());
//               System.out.println("start_date : " + start_date);
               
               JsonObject jobj_end_dt = dataset.getAsJsonObject();
               JsonElement end_date = jobj_end_dt.get("end_date");
               gdpset.setEnd_date(end_date.getAsString());
//               System.out.println("end_date : " + end_date);

               JsonObject jobj_data = dataset.getAsJsonObject();
               JsonElement data = jobj_data.get("data");
//               System.out.println("is data element an array ? : " + 
//                                   data.isJsonArray() + " of " + 
//                                   data.getAsJsonArray().size());
// Δημιουργία HashMaps για να αποθηκεύσουμε τις τιμές των πινάκων
               HashMap hm1 = new HashMap();

               HashMap hm2 = new HashMap();

// <<<< Εισαγωγή for loop για εμφάνιση όλων των τιμών
               for (int j=0; j < data.getAsJsonArray().size(); j++) {
               JsonElement jobj = jobj_data.get("data").getAsJsonArray().get(j);
//               System.out.println("is data element an array ? : " + 
//                                   jobj.isJsonArray() + " of " + jobj.getAsJsonArray().size() + " " +
//                                   jobj.toString()
//               );                
//  Για objects τύπου πίνακες χρειαζόμαστε έναν json reader                  
               JsonReader jsonReader1 = new JsonReader(new StringReader(jobj.toString()));
// Διατρέχουμε το column_names , εντοπίζουμε τις διαφορετικές τιμές και τις περνάμε σε άλλα πεδία  
               JsonArray jsonArray1 = new JsonArray();
               jsonArray1 = jobj.getAsJsonArray();               
               try {
                    while(jsonReader1.hasNext()){
                    JsonToken nextToken1 = jsonReader1.peek();
//                    System.out.println(nextToken);
                    if(JsonToken.BEGIN_ARRAY.equals(nextToken1)){
                       jsonReader1.beginArray();
                      } 
                       else 
                    if(JsonToken.NAME.equals(nextToken1)){
                       String name2  =  jsonReader1.nextName();
//                       System.out.println(name2);
                      } 
                       else 
                    if(JsonToken.STRING.equals(nextToken1)){
                       String value3 =  jsonReader1.nextString();
                       jsonArray1.add(value3);
                       hm1.put(j, value3);
//                       System.out.println("value 3 : " + value3);
                      } 
                       else 
                    if(JsonToken.NUMBER.equals(nextToken1)){
                        if ("GDP".equals(abc)) {
//                       System.out.println("jsonReader1.nextLong() = " + jsonReader1.nextLong());
                       long value4 =  jsonReader1.nextLong();
                       hm2.put(j, value4);
                        } else 
                        if ("OIL".equals(abc)) {
//                       System.out.println("jsonReader1.nextDouble() = " + jsonReader1.nextDouble());
                       Double value4 =  jsonReader1.nextDouble();
                       hm2.put(j, value4);
                        }
//                       jsonArray1.add(value4);
////                       System.out.println("value 4 : " + value4);  
                      }
                    } // end while  
                       gdpset.setHm1(hm1);
                       gdpset.setHm2(hm2);
} catch(IOException e) {
    e.printStackTrace();         
}     
               } // >>>> Εδώ τελειώνει η for loop που ξεκινήσαμε
//                  for (int l=0; l< gdpset.getHm1().size(); l++) {
//                       System.out.println("gdpset.getHm1.["+l+"] : "+gdpset.getHm1().get(l).toString());
//                       }
//                  for (int l=0; l< gdpset.getHm2().size(); l++) {
//                       System.out.println("gdpset.getHm2.["+l+"] : "+gdpset.getHm2().get(l).toString());
//                       }
               JsonObject jobj_coll = dataset.getAsJsonObject();
               JsonElement collapse = jobj_coll.get("collapse");
               if (!(collapse.isJsonNull())) {
                   gdpset.setCollapse(collapse.getAsString());
               }
//               System.out.println("collapse : " + collapse);

               JsonObject jobj_order = dataset.getAsJsonObject();
               JsonElement order = jobj_order.get("order");
               if (!(order.isJsonNull())) {
                   gdpset.setOrder(order.getAsString());
                }
//               System.out.println("order : " + order);

               JsonObject jobj_db_id = dataset.getAsJsonObject();
               JsonElement database_id = jobj_db_id.get("database_id");
               gdpset.setDatabase_id(database_id.getAsInt());
//               System.out.println("database_id : " + database_id);                        
                       
           } // end if of dataset check 
    }; // end if of jsonTree check
       this.Dataset = gdpset;
       if (jsonTree.isJsonArray()) indicator = 2;
       if (jsonTree.isJsonNull()) indicator = 3;
       if (jsonTree.isJsonPrimitive()) indicator = 4;
//       System.out.println("jsonTree indicator : " + indicator);
    return this;
    }                 

    /**
     * @return the gdpDataset
     */
    public DataSet getDataset() {
        return Dataset;
    }

    /**
     * @param Dataset the Dataset to set
     */
    public void setDataset(DataSet Dataset) {
        this.Dataset = Dataset;
    }
}

package Econometrica;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

import GuiDesign.MainForm;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;

public class Econometrica {
    
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //εμφάνιση του κεντρικού μενου
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true);
            }
        });
        

        
        

        
    
        /*System.out.println("123");
        String str1 = "https://www.quandl.com/api/v3/datasets/WWDI/";
        String str2 = "https://www.quandl.com/api/v3/datasets/";
        String lastthree = selection.substring(selection.length() - 3);
        
        
        String gdp_code = "_NY_GDP_MKTP_CN";
        String oil_code = "BP/OIL_CONSUM_";
        String apikey = ".json?api_key=j79mQ_zEuVUqFV1DihJT";
        
        String url1 = str1+lastthree+gdp_code+apikey;
        String url2 = str2+oil_code+lastthree+apikey;
        
        OkHttpClient client = new OkHttpClient();

        Request request1 = new Request.Builder().url(url1).build();
        Request request2 = new Request.Builder().url(url2).build();

        try (Response response1 = client.newCall(request1).execute()) {
            if(response1.isSuccessful() && response1.body() != null) {
                String responseString1 =  response1.body().string();
                //System.out.println(responseString1);
                ParseData parse1 = new ParseData();
                parse1.parseData(responseString1);
                }
            } catch (IOException e) {
        }       catch (ParseException ex) {
                    Logger.getLogger(MainForm_.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        try (Response response2 = client.newCall(request2).execute()) {
            if(response2.isSuccessful() && response2.body() != null) {
                String responseString2 =  response2.body().string();
                //System.out.println(responseString2);
                ParseData parse2 = new ParseData();
                parse2.parseData(responseString2);
                }
            } catch (IOException e) {
        }       catch (ParseException ex) {   
                    Logger.getLogger(MainForm_.class.getName()).log(Level.SEVERE, null, ex);
                }   
                */
        
        
        
    }
}
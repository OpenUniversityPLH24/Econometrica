/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.io.IOException;
import javax.swing.SwingWorker;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author vborotis
 */
public class MyOkHttp extends SwingWorker {
    private String key = "75ubJt2gtjie_dte2Rb7";
    private String url1 = "https://www.quandl.com/api/v3/datasets/WWDI/";
    private String url2 = "_NY_GDP_MKTP_CN.json?api_key=";
    private String url3 = "https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_";
    private String url4 = ".json?api_key=";    
// GDP
// https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=ΤΟ_ΚΛΕΙΔΙ_ΕΔΩ
// OIL
// https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json?api_key=ΚΛΕΙΔΙ_ΕΔΩ 

// ind is indicator for Oil or GDP Data retreive
// for Oil data ind = "OIL", for GRD data ind = "GDP"
    
    public String MyOkHttp (String cntr, String ind) {
    String urlToCall = "";
    String results = "";
    if (ind == "GDP") {
           urlToCall = url1 + cntr + url2 + key;
    }
    if (ind == "OIL") {
           urlToCall = url3 + cntr + url4 + key;
    } 
    
//    System.out.println(urlToCall);
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url(urlToCall).build();
    
    try (Response response = client.newCall(request).execute()) {
         if (response.isSuccessful() && response.body() != null) {
             results = response.body().string();
//             System.out.println(results);
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
    return results;
    }

    @Override
    protected Object doInBackground() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

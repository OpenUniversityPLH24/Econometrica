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

public class gpd {
    gpd(String dataset_code, String name, String description, List<String> dates, List<String> values) {
        this.dataset_code = dataset_code;
        this.description = description;
        this.name = name;
        this.dates = dates;
        this.values = values;
    }

    private String dataset_code;
    private String description;
    private String name;
    private List<String> dates;
    private List<String> values;
    
    public String getDataSet_Code() {
        return dataset_code;
    }

    public void setDataSet_Code(String dataset_code) {
        this.dataset_code = dataset_code;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}

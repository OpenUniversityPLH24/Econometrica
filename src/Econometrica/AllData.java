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

public class AllData {
    private Country countries;
    private List<CountryData> country_datas;
    private CountryDataset country_datasets;

    public AllData(Country countries, List<CountryData> country_datas, CountryDataset country_datasets) {
        this.countries = countries;
        this.country_datasets = country_datasets;
        this.country_datas = country_datas;
    }

    public Country getCountry() {
        return countries;
    }

    public void setCountry(Country countries) {
        this.countries = countries;
    }
    
    public List<CountryData> getCountryData() {
        return country_datas;
    }

    public void addCountryData(CountryData e) {
        country_datas.add(e);
    }
    
    public CountryDataset getCountryDataset() {
        return country_datasets;
    }

    public void setCountryDataset(CountryDataset country_datasets) {
        this.country_datasets = country_datasets;
    }
}
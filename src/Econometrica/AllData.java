/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Econometrica;

/**
 *
 * @author Χρήστος Ντάφος
 */
public class AllData {
    private Country countries;
    private CountryData country_datas;
    private CountryDataset country_datasets;

    public AllData(Country countries, CountryData country_datas, CountryDataset country_datasets) {
        this.countries = countries;
        this.country_datas = country_datas;
        this.country_datasets = country_datasets;
    } 
    
    public Country getCountry() {
        return countries;
    }

    public void setCountry(Country countries) {
        this.countries = countries;
    }
    
    public CountryData getCountryData() {
        return country_datas;
    }

    public void setCountry(CountryData country_datas) {
        this.country_datas = country_datas;
    }
    
    public CountryDataset getCountryDataset() {
        return country_datasets;
    }

    public void setCountryDataset(CountryDataset country_datasets) {
        this.country_datasets = country_datasets;
    }
}
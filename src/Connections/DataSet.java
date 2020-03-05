/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author vborotis
 */
public class DataSet {

    private int id;
    private String dataset_code;
    private String database_code;
    private String name;
    private String description;
    private Date refreshed_at;
    private String newest_available_date;
    private String oldest_available_date;
    private ArrayList column_names;
    private String frequency;
    private String type;
    private Boolean premium;
    private String limit;
    private String transform;
    private String column_index;
    private String start_date;
    private String end_date;
    private HashMap hm1;
    private HashMap hm2;
    private String collapse;
    private String order;
    private int database_id;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    sdf.parse("2019-06-25T21:19:10.949Z");
//    
//    data.getData[0].value;
//    date.getData
    

//    public void DataSet(int id) {
//        this.id = id;
//    } 
    
        
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the dataset_code
     */
    public String getDataset_code() {
        return dataset_code;
    }

    /**
     * @param dataset_code the dataset_code to set
     */
    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    /**
     * @return the database_code
     */
    public String getDatabase_code() {
        return database_code;
    }

    /**
     * @param database_code the database_code to set
     */
    public void setDatabase_code(String database_code) {
        this.database_code = database_code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the refreshed_at
     */
    public Date getRefreshed_at() {
        return refreshed_at;
    }

    /**
     * @param refreshed_at the refreshed_at to set
     */
    public void setRefreshed_at(String refreshed_at) throws ParseException {
    // sdf.parse("2019-06-25T21:19:10.949Z");

        this.refreshed_at = sdf.parse(refreshed_at);
    }

    /**
     * @return the newest_available_date
     */
    public String getNewest_available_date() {
        return newest_available_date;
    }

    /**
     * @param newest_available_date the newest_available_date to set
     */
    public void setNewest_available_date(String newest_available_date) {
        this.newest_available_date = newest_available_date;
    }

    /**
     * @return the oldest_available_date
     */
    public String getOldest_available_date() {
        return oldest_available_date;
    }

    /**
     * @param oldest_available_date the oldest_available_date to set
     */
    public void setOldest_available_date(String oldest_available_date) {
        this.oldest_available_date = oldest_available_date;
    }

    /**
     * @return the column_names
     */
    public ArrayList getColumn_names() {
        return column_names;
    }

    /**
     * @param column_names the column_names to set
     */
    public void setColumn_names(ArrayList column_names) {
        this.column_names = column_names;
    }
    
    /**
     * @return the frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
 
    /**
     * @return the premium
     */
    public Boolean getPremium() {
        return premium;
    }

    /**
     * @param premium the premium to set
     */
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    /**
     * @return the limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * @return the transform
     */
    public String getTransform() {
        return transform;
    }

    /**
     * @param transform the transform to set
     */
    public void setTransform(String transform) {
        this.transform = transform;
    }

    /**
     * @return the column_index
     */
    public String getColumn_index() {
        return column_index;
    }

    /**
     * @param column_index the column_index to set
     */
    public void setColumn_index(String column_index) {
        this.column_index = column_index;
    }

    /**
     * @return the start_date
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the end_date
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    /**
     * @return the hm1
     */
    public HashMap getHm1() {
        return hm1;
    }

    /**
     * @param hm1 the hm1 to set
     */
    public void setHm1(HashMap hm1) {
        this.hm1 = hm1;
    }

    /**
     * @return the hm2
     */
    public HashMap getHm2() {
        return hm2;
    }

    /**
     * @param hm2 the hm2 to set
     */
    public void setHm2(HashMap hm2) {
        this.hm2 = hm2;
    }

    /**
     * @return the collapse
     */
    public String getCollapse() {
        return collapse;
    }

    /**
     * @param collapse the collapse to set
     */
    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    /**
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * @return the database_id
     */
    public int getDatabase_id() {
        return database_id;
    }

    /**
     * @param database_id the database_id to set
     */
    public void setDatabase_id(int database_id) {
        this.database_id = database_id;
    }
    
}

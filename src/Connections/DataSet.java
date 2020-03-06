/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

 public class DataSet{
        @SerializedName("id")
        private int id;
        private String name;
        private String description;
        @SerializedName("start_date")
        private String startDate;
        @SerializedName("end_date")
        private String endDate;
        private List<ArrayList<Object>> data;
        
    public DataSet(int id, String name, String description, List<ArrayList<Object>> data){
        this.id = id;
        this.name = name;
        this.description = description;
        this.data = data;
    }     

        public int getId() {
            return id;
        }
        
        public void setId(int id) {
		this.id = id;
	}

        public String getName() {
            return name;
        }
        
        public void setName(String name) {
		this.name = name;
	}

        public String getDescription() {
            return description;
        }
        
        public void setDescription(String description) {
		this.description = description;
	}

        public String getStartDate() {
            return startDate;
        }
        
        public String getEndDate() {
            return endDate;
        }
        
        public List<ArrayList<Object>> getData() {
            return data;
        }

    @Override
    public String toString() {
        return "DataSet{" + "id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", data=" + data + '}';
    }
        
        
 }    

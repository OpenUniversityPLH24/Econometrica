/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vborotis
 */
public class ReadCSVFile {

    /**
     * @return the Name
     */
    
private ArrayList Name;   // Country Name
private ArrayList Alpha2; // Country Alpha2 code
private ArrayList Alpha3; // Country Alpha3 code
private ArrayList Number; // Country number

    public ArrayList getName() {
        return this.Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(ArrayList Name) {
        this.Name = Name;
    }
    
    public void addName(int i, String name) {
        this.Name.add(i, name);
    }

    /**
     * @return the Alpha2
     */
    public ArrayList getAlpha2() {
        return this.Alpha2;
    }

    /**
     * @param Alpha2 the Alpha2 to set
     */
    public void setAlpha2(ArrayList Alpha2) {
        this.Alpha2 = Alpha2;
    }

    /**
     * @return the Alpha3
     */
    public ArrayList getAlpha3() {
        return this.Alpha3;
    }
    
    public String getAlpha3Code(int code){
         String A3Code = this.Alpha3.get(code).toString();
       return A3Code;
    }

    /**
     * @param Alpha3 the Alpha3 to set
     */
    public void setAlpha3(ArrayList Alpha3) {
        this.Alpha3 = Alpha3;
    }

    /**
     * @return the number
     */
    public ArrayList getNumber() {
        return this.Number;
    }
    
    public int getCountryID (String name) {
        int num = -1;
        for (int i=0; i< this.Name.size(); i++) {
             if (this.Name.get(i).toString()==name) {
              num = i;
             } 
        }
        return num;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(ArrayList number) {
        this.Number = number;
    }


//    public void ReadCSVFile () {
//    
//    }
    
    public void ReadCSVFile () {
    String FileName = "iso-countries.csv"; 
    ArrayList name = new ArrayList();
    ArrayList alpha2 = new ArrayList();
    ArrayList alpha3 = new ArrayList();
    ArrayList number = new ArrayList();
// **************************************************************
try
{
    try
        (FileReader inputFile = new FileReader(FileName)) {
         Scanner parser = new Scanner(inputFile);
         int cnt = 0;
         while (parser.hasNextLine()) {
		String line = parser.nextLine();
	        String[] col = line.split(";");
//		System.out.println(col[0]);
                name.add(cnt, col[0]);
//	        System.out.println(col[1]);
                alpha2.add(cnt, col[1]);
//		System.out.println(col[2]);
                alpha3.add(cnt, col[2]);
//		System.out.println(col[3]);
                number.add(cnt, col[3]);
                cnt = cnt +1;
                }
//         this.Name = name;
         this.setName(name);
         this.setAlpha2(alpha2);
         this.setAlpha3(alpha3);
         this.setNumber(number);
//         this.Name = name;
//         this.Alpha2 = alpha2;
//         this.Alpha3 = alpha3;
//         this.Number = number;
         
//         for (int i=0; i < this.Name.size() ; i++) {
//         System.out.println("Name = "+
//                            this.Name.get(i).toString()+" Alpha2 = "+
//                            this.Alpha2.get(i).toString()+" Alpha3 = "+
//                            this.Alpha3.get(i).toString()+" Number = "+
//                            this.Number.get(i).toString());
//         }
        }
} catch(FileNotFoundException exception) {
	System.out.println(FileName + " not found");
  }
  catch(IOException exception) {
	System.out.println("Unexpected I/O error occured.");
  }      
 }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import Database.Country;
import Database.CountryData;
import Database.CountryDataset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vborotis
 */
public class JPA {

public static EntityManager em ;

    
//    public static void main(String[] args) {
    public static void JPA() {
//        DBManager dbm = new DBManager();
//        dbm.DBManager();
        em = DBManager.getEm();
//        em.getTransaction().begin();
        
//        EntityManager em = new EntityManager();
//       
//        
//        EntityManagerFactory emf = 
//            Persistence.createEntityManagerFactory("JPATestPU");
//        em = emf.createEntityManager();
//        // από εδώ αρχίζουν τα transactions
//        
//        removeCustomer(10);
//       
//        em.close();
//        emf.close();
    }
    
    public static Country retreiveCountry(String name){
    
    em = DBManager.getEm();
    Country country = new Country();
    
        try {
//        System.out.println("name = " + name);
        country = em.createNamedQuery("Country.findByName",Country.class).setParameter("name", name).getSingleResult();
//        System.out.println("Country ISO code = " + cntry.getIsoCode());
        return country;
        } catch (Exception ex){
             System.out.println("Exception occurred " + ex.getMessage());
            return null;
        }
    }
    
    public static void createCountry( Country country ) {
//                                        Integer id, Date date, int quantity, float price, 
//            Customer c, Stock s){
        em.getTransaction().begin();
//        Country c = new Country( country.getIsoCode(), country.getName() );
//        Trans t = new  Trans( id,  date,  quantity,  price);
        // αν κάνω τώρα persist, θα έχω σφάλμα γιατί υπάρχουν relationships
        // ...θέτω σωστά τα relationships
//        t.setCustomerId(c); // FK_CUSTOMER_ID
//        t.setStockId(s); //FK_STOCK_ID
        
        //...και τώρα το persist δεν θα έχει σφάλμα!
        //το t είναι new, αλλά δεν είναι managed ακόμα
        // (δεν έχει αναλάβει τη διαχείρησή του ο EntityManager)
        
        em.persist(country);
        // μετά το persist το t τώρα είναι managed!  
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπει μόνο το 
        // transaction αυτό 
        
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπουν όλοι
        em.getTransaction().commit(); 
//        return c;
    }
    
    public static void createCountryDataset( CountryDataset countryDataset ) {
//                                        Integer id, Date date, int quantity, float price, 
//            Customer c, Stock s){
        em.getTransaction().begin();
//        Country c = new Country( country.getIsoCode(), country.getName() );
//        Trans t = new  Trans( id,  date,  quantity,  price);
        // αν κάνω τώρα persist, θα έχω σφάλμα γιατί υπάρχουν relationships
        // ...θέτω σωστά τα relationships
//        t.setCustomerId(c); // FK_CUSTOMER_ID
//        t.setStockId(s); //FK_STOCK_ID
        CountryDataset cd = new CountryDataset(
//                                               countryDataset.getDatasetId(),
                                               countryDataset.getStartYear(),
                                               countryDataset.getName(),
                                               countryDataset.getDescription(),
                                               countryDataset.getEndYear(),
                                               countryDataset.getCountryCode());
        //...και τώρα το persist δεν θα έχει σφάλμα!
        //το t είναι new, αλλά δεν είναι managed ακόμα
        // (δεν έχει αναλάβει τη διαχείρησή του ο EntityManager)
        
        em.persist(cd);
        // μετά το persist το t τώρα είναι managed!  
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπει μόνο το 
        // transaction αυτό 
        
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπουν όλοι
        em.getTransaction().commit(); 
//        return c;
    }
    
    public static void createCountryData( ArrayList<CountryData> countryDataLst ) {
//                                        Integer id, Date date, int quantity, float price, 
//            Customer c, Stock s){
        em.getTransaction().begin();
//        Country c = new Country( country.getIsoCode(), country.getName() );
//        Trans t = new  Trans( id,  date,  quantity,  price);
        // αν κάνω τώρα persist, θα έχω σφάλμα γιατί υπάρχουν relationships
        // ...θέτω σωστά τα relationships
//        t.setCustomerId(c); // FK_CUSTOMER_ID
//        t.setStockId(s); //FK_STOCK_ID
        for (int i=0; i< countryDataLst.size(); i++) {
        CountryData cd = new CountryData(countryDataLst.get(i).getDataset().getDatasetId(),
                                         countryDataLst.get(i).getDataYear(),
                                         countryDataLst.get(i).getValue());
        //...και τώρα το persist δεν θα έχει σφάλμα!
        //το t είναι new, αλλά δεν είναι managed ακόμα
        // (δεν έχει αναλάβει τη διαχείρησή του ο EntityManager)
        
        em.persist(cd);
        }
        // μετά το persist το t τώρα είναι managed!  
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπει μόνο το 
        // transaction αυτό 
        
        // τώρα δημιουργείται η εγγραφή στην DB και την βλέπουν όλοι
        em.getTransaction().commit(); 
//        return c;
    }
    
    public static void DeleteAll(){
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EconometricaPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.createNamedQuery("CountryData.deleteAll").executeUpdate();
            em.createNamedQuery("CountryDataset.deleteAll").executeUpdate();
            em.createNamedQuery("Country.deleteAll").executeUpdate();
            em.createNativeQuery("ALTER TABLE Country_Data ALTER COLUMN ID RESTART WITH 1").executeUpdate();
            em.getTransaction().commit();
            em.close();
            emf.close();
            JOptionPane.showMessageDialog(null, "Τα δεδομένα διαγράφηκαν");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Τα δεδομένα δεν διαγράφηκαν");
        }
    }
}

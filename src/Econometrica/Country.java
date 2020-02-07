/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Econometrica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * test2
 * @author Χρήστος Ντάφος
 */
@Entity
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
    , @NamedQuery(name = "Country.findByIsoCode", query = "SELECT c FROM Country c WHERE c.isoCode = :isoCode")
    , @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISO_CODE")
    private String isoCode;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "countryCode")
    private Collection<CountryDataset> countryDatasetCollection;

    public Country() {
    }

    public Country(String isoCode) {
        this.isoCode = isoCode;
    }

    public Country(String isoCode, String name) {
        this.isoCode = isoCode;
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<CountryDataset> getCountryDatasetCollection() {
        return countryDatasetCollection;
    }

    public void setCountryDatasetCollection(Collection<CountryDataset> countryDatasetCollection) {
        this.countryDatasetCollection = countryDatasetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isoCode != null ? isoCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.isoCode == null && other.isoCode != null) || (this.isoCode != null && !this.isoCode.equals(other.isoCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Econometrica.Country[ isoCode=" + isoCode + " ]";
    }
    
}

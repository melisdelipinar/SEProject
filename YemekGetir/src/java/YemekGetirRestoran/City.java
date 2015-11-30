/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 *
 * @author xxxxxxxxx
 */
@Entity
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByCityid", query = "SELECT c FROM City c WHERE c.cityid = :cityid"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
    @NamedQuery(name = "City.findByPlatecode", query = "SELECT c FROM City c WHERE c.platecode = :platecode")})
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cityid")
    private Integer cityid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "platecode")
    private int platecode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityid")
    private Collection<Distinct> distinctCollection;

    public City() {
    }

    public City(Integer cityid) {
        this.cityid = cityid;
    }

    public City(Integer cityid, String name, int platecode) {
        this.cityid = cityid;
        this.name = name;
        this.platecode = platecode;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlatecode() {
        return platecode;
    }

    public void setPlatecode(int platecode) {
        this.platecode = platecode;
    }

    @XmlTransient
    public Collection<Distinct> getDistinctCollection() {
        return distinctCollection;
    }

    public void setDistinctCollection(Collection<Distinct> distinctCollection) {
        this.distinctCollection = distinctCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.City[ cityid=" + cityid + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "distinct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distinct.findAll", query = "SELECT d FROM Distinct d"),
    @NamedQuery(name = "Distinct.findByDistinctid", query = "SELECT d FROM Distinct d WHERE d.distinctid = :distinctid"),
    @NamedQuery(name = "Distinct.findByName", query = "SELECT d FROM Distinct d WHERE d.name = :name")})
public class Distinct implements Serializable {
    private static final long serialVersionUID = 1L;
     PreparedStatement psmt;    
     Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "Distinctid")
    private Integer distinctid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distinctid")
    private Collection<Restaurant> restaurantCollection;
    @JoinColumn(name = "cityid", referencedColumnName = "cityid")
    @ManyToOne(optional = false)
    private City cityid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distinctid")
    private Collection<Address> addressCollection;

    public Distinct() {
    }

    public Distinct(Integer distinctid) {
        this.distinctid = distinctid;
    }

    public Distinct(Integer distinctid, String name) {
        this.distinctid = distinctid;
        this.name = name;
    }

    public Integer getDistinctid() {
        return distinctid;
    }

    public void setDistinctid(Integer distinctid) {
        this.distinctid = distinctid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distinctid != null ? distinctid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distinct)) {
            return false;
        }
        Distinct other = (Distinct) object;
        if ((this.distinctid == null && other.distinctid != null) || (this.distinctid != null && !this.distinctid.equals(other.distinctid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Distinct[ distinctid=" + distinctid + " ]";
    }
     public String getDistinctName(int id){
        Database.database.startDB();
        conn=Database.database.getConnection();
        if(conn!=null){
            try {
                String sql="SELECT name FROM `yemekgetir`.`distinct` NATURAL JOIN address where addressid= ?";
                psmt=conn.prepareStatement(sql);
                psmt.setInt(1, id);
                System.out.println(id);
                ResultSet rs= psmt.executeQuery();
                
                if(rs.next()){
                    return rs.getString(1);
                    }
                    rs.close();
            } catch (SQLException ex) {
                System.out.println("password ex");
                return  null;
            }
             
    }
     return null;
    }
    
}

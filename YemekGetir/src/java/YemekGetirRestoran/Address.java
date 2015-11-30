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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByAddressDetails", query = "SELECT a FROM Address a WHERE a.addressDetails = :addressDetails"),
    @NamedQuery(name = "Address.findByType", query = "SELECT a FROM Address a WHERE a.type = :type")})
public class Address implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
 
    private static final long serialVersionUID = 1L;
    PreparedStatement psmt;    
     Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "addressid")
    private Integer addressid;
    @Basic(optional = false)
    @Column(name = "addressDetails")
    private String addressDetails;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @JoinTable(name = "useraddresses", joinColumns = {
        @JoinColumn(name = "addressid", referencedColumnName = "addressid")}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "userid")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Order1> order1Collection;
    @JoinColumn(name = "distinctid", referencedColumnName = "Distinctid")
    @ManyToOne(optional = false)
    private Distinct distinctid;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Address(Integer addressid, String addressDetails, int type) {
        this.addressid = addressid;
        this.addressDetails = addressDetails;
        this.type = type;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Distinct getDistinctid() {
        return distinctid;
    }

    public void setDistinctid(Distinct distinctid) {
        this.distinctid = distinctid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Address[ addressid=" + addressid + " ]";
    }
    
    public String bringAdressDetails(int id){
        Database.database.startDB();
        conn=Database.database.getConnection();
           if(conn!=null){
            try {
                String sql="SELECT addressDetails FROM yemekgetir.address WHERE addressid= ?";
                psmt=conn.prepareStatement(sql);
                
                psmt.setInt(1, id);
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    return rs.getString(1);
                    }
                    rs.close();
            } catch (SQLException ex) {
                System.out.println("bringaddress ex");
                return  null;
            }
             
    }
     return null;
    }
    
    

}

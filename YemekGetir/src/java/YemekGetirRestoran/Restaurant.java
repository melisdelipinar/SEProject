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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByRestaurantId", query = "SELECT r FROM Restaurant r WHERE r.restaurantId = :restaurantId"),
    @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name"),
    @NamedQuery(name = "Restaurant.findByPhoneNumber", query = "SELECT r FROM Restaurant r WHERE r.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Restaurant.findByIsOpened", query = "SELECT r FROM Restaurant r WHERE r.isOpened = :isOpened"),
    @NamedQuery(name = "Restaurant.findByMinimumServiceCost", query = "SELECT r FROM Restaurant r WHERE r.minimumServiceCost = :minimumServiceCost"),
    @NamedQuery(name = "Restaurant.findByPassword", query = "SELECT r FROM Restaurant r WHERE r.password = :password"),
    @NamedQuery(name = "Restaurant.findByEmail", query = "SELECT r FROM Restaurant r WHERE r.email = :email")})
public class Restaurant implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<Order1> order1Collection;
    private static final long serialVersionUID = 1L;
    PreparedStatement psmt;
    Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "restaurantId")
    private Integer restaurantId;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "isOpened")
    private boolean isOpened;
    @Basic(optional = false)
    @Column(name = "minimumServiceCost")
    private double minimumServiceCost;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "userfavourites", joinColumns = {
        @JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "userid")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "distinctid", referencedColumnName = "Distinctid")
    @ManyToOne(optional = false)
    private Distinct distinctid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<Usercommandratings> usercommandratingsCollection;

    public Restaurant() {
    }

    public Restaurant(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant(Integer restaurantId, String address, String name, String phoneNumber, boolean isOpened, double minimumServiceCost, String password, String email) {
        this.restaurantId = restaurantId;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isOpened = isOpened;
        this.minimumServiceCost = minimumServiceCost;
        this.password = password;
        this.email = email;
    }

    public void bringPassword(){
        Database.database.startDB();
        conn=Database.database.getConnection();
        if(conn!=null){
            try {
                String sql="select password from yemekgetir.restaurant where email=?";
                psmt= conn.prepareStatement(sql);
                psmt.setString(1,email);
                
                ResultSet rs=psmt.executeQuery();
                if(rs.next()){
                    password=rs.getString("password");
                    System.out.println(password);
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("mail ex");
            }
            
        }
    }
    
    public String getRestaurantName(int id){
        Database.database.startDB();
        conn=Database.database.getConnection();
        if(conn!=null){
            try {
                
                String sql="select name from yemekgetir.restaurant where restaurantId =?";
                psmt=conn.prepareStatement(sql);
                psmt.setInt(1, id);
                
                ResultSet rs= psmt.executeQuery();
                
                if(rs.next()){
                  return rs.getString(1);
                        
                    }
                    rs.close();
                }
           
                
                
                
             catch (SQLException ex) {
                System.out.println("password ex");
                return null;
                
            }
    }
          return null;
    }
    
  
    public boolean checkPassword(){
        Database.database.startDB();
        conn=Database.database.getConnection();
        if(conn!=null){
            try {
                
                String sql="select password from yemekgetir.restaurant where email =?";
                psmt=conn.prepareStatement(sql);
                psmt.setString(1, email);
                System.out.println(email);
                ResultSet rs= psmt.executeQuery();
                
                if(rs.next()){
                   if(rs.getString("password").equals(this.getPassword())){
                        System.out.println(this.getPassword());
                        return true;
                    }
                    rs.close();
                }
                
                
                
            } catch (SQLException ex) {
                System.out.println("password ex");
                return false;
            }
             
    }
       
       
      return false;
    }
    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsOpened() {
        return isOpened;
    }

    public void setIsOpened(boolean isOpened) {
        this.isOpened = isOpened;
    }

    public double getMinimumServiceCost() {
        return minimumServiceCost;
    }

    public void setMinimumServiceCost(double minimumServiceCost) {
        this.minimumServiceCost = minimumServiceCost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Distinct getDistinctid() {
        return distinctid;
    }

    public void setDistinctid(Distinct distinctid) {
        this.distinctid = distinctid;
    }

    @XmlTransient
    public Collection<Usercommandratings> getUsercommandratingsCollection() {
        return usercommandratingsCollection;
    }

    public void setUsercommandratingsCollection(Collection<Usercommandratings> usercommandratingsCollection) {
        this.usercommandratingsCollection = usercommandratingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restaurantId != null ? restaurantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restaurantId == null && other.restaurantId != null) || (this.restaurantId != null && !this.restaurantId.equals(other.restaurantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Restaurant[ restaurantId=" + restaurantId + " ]";
    }
    



}

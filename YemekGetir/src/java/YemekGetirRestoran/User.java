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
import javax.persistence.ManyToMany;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhoneNumber", query = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")})
public class User implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
 
    private static final long serialVersionUID = 1L;
       PreparedStatement psmt;
       PreparedStatement psmt2;
    Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Address> addressCollection;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Restaurant> restaurantCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Shoppingcart> shoppingcartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Usercommandratings> usercommandratingsCollection;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(Integer userid, String firstName, String lastName, String email, String phoneNumber) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
    }

    @XmlTransient
    public Collection<Shoppingcart> getShoppingcartCollection() {
        return shoppingcartCollection;
    }

    public void setShoppingcartCollection(Collection<Shoppingcart> shoppingcartCollection) {
        this.shoppingcartCollection = shoppingcartCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
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
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.User[ userid=" + userid + " ]";
    }
  public String bringUsername(int us){
           Database.database.startDB();
        conn=Database.database.getConnection();
        String[] nameSurname=new String[2];
        if(conn!=null){
             try {
                String sql= "select firstName from user where userid= ?";
                 psmt=conn.prepareStatement(sql);
                 psmt.setInt(1, us);
                 ResultSet rs= psmt.executeQuery();
                
                 if(rs.next()){
                  nameSurname[0]=rs.getString(1);
              } String sql2= "select lastName from user where userid= ?";
                psmt2=conn.prepareStatement(sql2);
                psmt2.setInt(1, us);
                ResultSet rs2= psmt2.executeQuery(); 
                if(rs2.next()){
                 nameSurname[1]=rs2.getString(1);
              }
              
            } catch (SQLException ex) {
               System.out.println("startdb - sqlexception");
            return null;
            }
            
        }
         return nameSurname[0]+" "+ nameSurname[1];
     }
  
  public String bringUserPhoneNumber(int id){
             Database.database.startDB();
            conn=Database.database.getConnection();
            String[] nameSurname=new String[2];
            if(conn!=null){
             try {
                String sql= "SELECT phoneNumber FROM user WHERE userid= ?";
                 psmt=conn.prepareStatement(sql);
                 psmt.setInt(1, id);
                 ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                  return rs.getString(1);}
              
            } catch (SQLException ex) {
               System.out.println("bringUserPhone - sqlexception");
            return null;
            }
            
        }
         return null;
     }
  
}



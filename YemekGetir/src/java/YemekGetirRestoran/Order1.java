/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import YemekGetirRestoran.Address;
import YemekGetirRestoran.Restaurant;
import YemekGetirRestoran.Shoppingcart;
import YemekGetirRestoran.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IBM
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderid", query = "SELECT o FROM Order1 o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Order1.findByTotalPrice", query = "SELECT o FROM Order1 o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Order1.findByOrdertime", query = "SELECT o FROM Order1 o WHERE o.ordertime = :ordertime"),
    @NamedQuery(name = "Order1.findByDeliveryTime", query = "SELECT o FROM Order1 o WHERE o.deliveryTime = :deliveryTime"),
    @NamedQuery(name = "Order1.findByChecked", query = "SELECT o FROM Order1 o WHERE o.checked = :checked")})
public class Order1 implements Serializable {
    private static final long serialVersionUID = 1L;
    PreparedStatement psmt;
    Connection conn;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderid")
    private Integer orderid;
    @Basic(optional = false)
    @Column(name = "totalPrice")
    private double totalPrice;
    @Basic(optional = false)
    @Column(name = "ordertime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordertime;
    @Basic(optional = false)
    @Column(name = "deliveryTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryTime;
    @Basic(optional = false)
    @Column(name = "checked")
    private int checked;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userid;
    @JoinColumn(name = "addressId", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "cartid", referencedColumnName = "ShoppingCartid")
    @ManyToOne(optional = false)
    private Shoppingcart cartid;
    @JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
    @ManyToOne(optional = false)
    private Restaurant restaurantId;

    public Order1() {
    }

    public Order1(Integer orderid) {
        this.orderid = orderid;
    }

    public Order1(Integer orderid, double totalPrice, Date ordertime, Date deliveryTime, int checked) {
        this.orderid = orderid;
        this.totalPrice = totalPrice;
        this.ordertime = ordertime;
        this.deliveryTime = deliveryTime;
        this.checked = checked;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Shoppingcart getCartid() {
        return cartid;
    }

    public void setCartid(Shoppingcart cartid) {
        this.cartid = cartid;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Order1[ orderid=" + orderid + " ]";
    }
        public boolean updateChecked(){
        Database.database.startDB();
        conn=Database.database.getConnection();
       
        if(conn!=null){
            try {
                String sql= "UPDATE `yemekgetir`.`order` SET checked = ? ";
                 psmt=conn.prepareStatement(sql);
                psmt.setInt(1, 1);
                int result=psmt.executeUpdate();
              if(result == -1){
                  return false;
              }
            } catch (SQLException ex) {
               System.out.println("startdb - sqlexception");
            return false;
            }
            
            
        }
        
        
        
        return true;
    }
        
        public String bringOrderTime(int id){
         Database.database.startDB();
         conn=Database.database.getConnection();
         String result;
         String[] dateTime;
         String[] date;
         String[] time;
         if(conn!=null){
            try {
                String sql="select ordertime FROM yemekgetir.`order` WHERE orderid= ?";
                psmt=conn.prepareStatement(sql);
                psmt.setInt(1, id);
                System.out.println(id);
                ResultSet rs= psmt.executeQuery();
                
                if(rs.next()){
                  dateTime= rs.getString(1).split(" ");
                  date=dateTime[0].split("-");
                  time=dateTime[1].split(":");
                  result=date[2]+"-"+date[1]+"-"+date[0] +" & "+time[0]+":"+time[1];
                   return result;
                    }
                    rs.close();
            } catch (SQLException ex) {
                System.out.println("password ex");
                return  null;
            }
             
    }        return null;
        }
   
    
}

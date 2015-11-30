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
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Payment.findByType", query = "SELECT p FROM Payment p WHERE p.type = :type"),
    @NamedQuery(name = "Payment.findByCost", query = "SELECT p FROM Payment p WHERE p.cost = :cost")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    PreparedStatement psmt;    
    Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "paymentId")
    private Integer paymentId;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @Column(name = "cost")
    private double cost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment\u0131d")
    private Collection<Onlinepayment> onlinepaymentCollection;
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    @ManyToOne(optional = false)
    private Order1 orderid;

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Payment(Integer paymentId, int type, double cost) {
        this.paymentId = paymentId;
        this.type = type;
        this.cost = cost;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @XmlTransient
    public Collection<Onlinepayment> getOnlinepaymentCollection() {
        return onlinepaymentCollection;
    }

    public void setOnlinepaymentCollection(Collection<Onlinepayment> onlinepaymentCollection) {
        this.onlinepaymentCollection = onlinepaymentCollection;
    }

    public Order1 getOrderid() {
        return orderid;
    }

    public void setOrderid(Order1 orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Payment[ paymentId=" + paymentId + " ]";
    }
    
      public String bringPaymentType(int id){
        Database.database.startDB();
        conn=Database.database.getConnection();
         if(conn!=null){
            try {
                String sql="SELECT  CASE \n" +
"            WHEN type = 1\n" +
"               THEN 'Nakit' \n" +
"			WHEN type = 2\n" +
"				THEN 'Kredi Karti'\n" +
"			WHEN type= 3 \n" +
"				THEN 'Online Kredi Karti'\n" +
"			END AS ODEME\n" +
"		\n" +
"FROM payment\n" +
"where orderid=?";
                psmt=conn.prepareStatement(sql);
                psmt.setInt(1, id);
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                 return rs.getString(1);
                    }
                    rs.close();
            } catch (SQLException ex) {
                System.out.println("bringPayment ex");
                return  null;
            }
             
    }
     return null;
    }
    
}

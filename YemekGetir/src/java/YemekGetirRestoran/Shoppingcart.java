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
@Table(name = "shoppingcart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByShoppingCartid", query = "SELECT s FROM Shoppingcart s WHERE s.shoppingCartid = :shoppingCartid"),
    @NamedQuery(name = "Shoppingcart.findByIsEmpty", query = "SELECT s FROM Shoppingcart s WHERE s.isEmpty = :isEmpty")})
public class Shoppingcart implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartid")
    
    private static final long serialVersionUID = 1L;
    PreparedStatement psmt;    
     Connection conn;
    @Id
    @Basic(optional = false)
    @Column(name = "ShoppingCartid")
    private Integer shoppingCartid;
    @Basic(optional = false)
    @Column(name = "isEmpty")
    private boolean isEmpty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingcart")
    private Collection<Menuitemtobuy> menuitemtobuyCollection;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartid")
    private Collection<Order1> order1Collection;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer shoppingCartid) {
        this.shoppingCartid = shoppingCartid;
    }

    public Shoppingcart(Integer shoppingCartid, boolean isEmpty) {
        this.shoppingCartid = shoppingCartid;
        this.isEmpty = isEmpty;
    }

    public Integer getShoppingCartid() {
        return shoppingCartid;
    }

    public void setShoppingCartid(Integer shoppingCartid) {
        this.shoppingCartid = shoppingCartid;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @XmlTransient
    public Collection<Menuitemtobuy> getMenuitemtobuyCollection() {
        return menuitemtobuyCollection;
    }

    public void setMenuitemtobuyCollection(Collection<Menuitemtobuy> menuitemtobuyCollection) {
        this.menuitemtobuyCollection = menuitemtobuyCollection;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingCartid != null ? shoppingCartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.shoppingCartid == null && other.shoppingCartid != null) || (this.shoppingCartid != null && !this.shoppingCartid.equals(other.shoppingCartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Shoppingcart[ shoppingCartid=" + shoppingCartid + " ]";
    }
    
    public String[] bringCartinfo(int id){
        Database.database.startDB();
        conn=Database.database.getConnection();
        String[] result=new String[2];
           if(conn!=null){
            try {
                String sql="SELECT menuItemName,quantity FROM yemekgetir.menuitem natural join menuitemtobuy where cartId=?";
                psmt=conn.prepareStatement(sql);
                psmt.setInt(1, id);
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                   result[0]=rs.getString(1);
                   result[1]=rs.getString(2);
                   return result;
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

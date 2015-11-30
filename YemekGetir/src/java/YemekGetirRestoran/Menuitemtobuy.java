/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xxxxxxxxx
 */
@Entity
@Table(name = "menuitemtobuy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuitemtobuy.findAll", query = "SELECT m FROM Menuitemtobuy m"),
    @NamedQuery(name = "Menuitemtobuy.findByMenuItemId", query = "SELECT m FROM Menuitemtobuy m WHERE m.menuitemtobuyPK.menuItemId = :menuItemId"),
    @NamedQuery(name = "Menuitemtobuy.findByCartId", query = "SELECT m FROM Menuitemtobuy m WHERE m.menuitemtobuyPK.cartId = :cartId"),
    @NamedQuery(name = "Menuitemtobuy.findByQuantity", query = "SELECT m FROM Menuitemtobuy m WHERE m.quantity = :quantity")})
public class Menuitemtobuy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuitemtobuyPK menuitemtobuyPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "menuItemId", referencedColumnName = "menuItemId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menuitem menuitem;
    @JoinColumn(name = "cartId", referencedColumnName = "ShoppingCartid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Shoppingcart shoppingcart;

    public Menuitemtobuy() {
    }

    public Menuitemtobuy(MenuitemtobuyPK menuitemtobuyPK) {
        this.menuitemtobuyPK = menuitemtobuyPK;
    }

    public Menuitemtobuy(MenuitemtobuyPK menuitemtobuyPK, int quantity) {
        this.menuitemtobuyPK = menuitemtobuyPK;
        this.quantity = quantity;
    }

    public Menuitemtobuy(int menuItemId, int cartId) {
        this.menuitemtobuyPK = new MenuitemtobuyPK(menuItemId, cartId);
    }

    public MenuitemtobuyPK getMenuitemtobuyPK() {
        return menuitemtobuyPK;
    }

    public void setMenuitemtobuyPK(MenuitemtobuyPK menuitemtobuyPK) {
        this.menuitemtobuyPK = menuitemtobuyPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Menuitem getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(Menuitem menuitem) {
        this.menuitem = menuitem;
    }

    public Shoppingcart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuitemtobuyPK != null ? menuitemtobuyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuitemtobuy)) {
            return false;
        }
        Menuitemtobuy other = (Menuitemtobuy) object;
        if ((this.menuitemtobuyPK == null && other.menuitemtobuyPK != null) || (this.menuitemtobuyPK != null && !this.menuitemtobuyPK.equals(other.menuitemtobuyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Menuitemtobuy[ menuitemtobuyPK=" + menuitemtobuyPK + " ]";
    }
    
}

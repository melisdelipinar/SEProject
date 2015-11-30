/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author xxxxxxxxx
 */
@Embeddable
public class MenuitemtobuyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "menuItemId")
    private int menuItemId;
    @Basic(optional = false)
    @Column(name = "cartId")
    private int cartId;

    public MenuitemtobuyPK() {
    }

    public MenuitemtobuyPK(int menuItemId, int cartId) {
        this.menuItemId = menuItemId;
        this.cartId = cartId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menuItemId;
        hash += (int) cartId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuitemtobuyPK)) {
            return false;
        }
        MenuitemtobuyPK other = (MenuitemtobuyPK) object;
        if (this.menuItemId != other.menuItemId) {
            return false;
        }
        if (this.cartId != other.cartId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.MenuitemtobuyPK[ menuItemId=" + menuItemId + ", cartId=" + cartId + " ]";
    }
    
}

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
public class MenuitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "menuItemId")
    private int menuItemId;
    @Basic(optional = false)
    @Column(name = "menuId")
    private int menuId;

    public MenuitemPK() {
    }

    public MenuitemPK(int menuItemId, int menuId) {
        this.menuItemId = menuItemId;
        this.menuId = menuId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menuItemId;
        hash += (int) menuId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuitemPK)) {
            return false;
        }
        MenuitemPK other = (MenuitemPK) object;
        if (this.menuItemId != other.menuItemId) {
            return false;
        }
        if (this.menuId != other.menuId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.MenuitemPK[ menuItemId=" + menuItemId + ", menuId=" + menuId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "menuitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuitem.findAll", query = "SELECT m FROM Menuitem m"),
    @NamedQuery(name = "Menuitem.findByMenuItemId", query = "SELECT m FROM Menuitem m WHERE m.menuitemPK.menuItemId = :menuItemId"),
    @NamedQuery(name = "Menuitem.findByMenuId", query = "SELECT m FROM Menuitem m WHERE m.menuitemPK.menuId = :menuId"),
    @NamedQuery(name = "Menuitem.findByPrice", query = "SELECT m FROM Menuitem m WHERE m.price = :price"),
    @NamedQuery(name = "Menuitem.findByDescription", query = "SELECT m FROM Menuitem m WHERE m.description = :description")})
public class Menuitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuitemPK menuitemPK;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "menuitemCollection")
    private Collection<Food> foodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuitem")
    private Collection<Menuitemtobuy> menuitemtobuyCollection;
    @JoinColumn(name = "menuId", referencedColumnName = "menuId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public Menuitem() {
    }

    public Menuitem(MenuitemPK menuitemPK) {
        this.menuitemPK = menuitemPK;
    }

    public Menuitem(MenuitemPK menuitemPK, double price, String description) {
        this.menuitemPK = menuitemPK;
        this.price = price;
        this.description = description;
    }

    public Menuitem(int menuItemId, int menuId) {
        this.menuitemPK = new MenuitemPK(menuItemId, menuId);
    }

    public MenuitemPK getMenuitemPK() {
        return menuitemPK;
    }

    public void setMenuitemPK(MenuitemPK menuitemPK) {
        this.menuitemPK = menuitemPK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Food> getFoodCollection() {
        return foodCollection;
    }

    public void setFoodCollection(Collection<Food> foodCollection) {
        this.foodCollection = foodCollection;
    }

    @XmlTransient
    public Collection<Menuitemtobuy> getMenuitemtobuyCollection() {
        return menuitemtobuyCollection;
    }

    public void setMenuitemtobuyCollection(Collection<Menuitemtobuy> menuitemtobuyCollection) {
        this.menuitemtobuyCollection = menuitemtobuyCollection;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuitemPK != null ? menuitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuitem)) {
            return false;
        }
        Menuitem other = (Menuitem) object;
        if ((this.menuitemPK == null && other.menuitemPK != null) || (this.menuitemPK != null && !this.menuitemPK.equals(other.menuitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Menuitem[ menuitemPK=" + menuitemPK + " ]";
    }
    
}

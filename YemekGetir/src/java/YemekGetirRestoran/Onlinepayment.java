/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YemekGetirRestoran;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "onlinepayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlinepayment.findAll", query = "SELECT o FROM Onlinepayment o"),
    @NamedQuery(name = "Onlinepayment.findByOnlinePaymentId", query = "SELECT o FROM Onlinepayment o WHERE o.onlinePaymentId = :onlinePaymentId"),
    @NamedQuery(name = "Onlinepayment.findByCreditCartNo", query = "SELECT o FROM Onlinepayment o WHERE o.creditCartNo = :creditCartNo"),
    @NamedQuery(name = "Onlinepayment.findByCartOwnerName", query = "SELECT o FROM Onlinepayment o WHERE o.cartOwnerName = :cartOwnerName"),
    @NamedQuery(name = "Onlinepayment.findBySecurityCode", query = "SELECT o FROM Onlinepayment o WHERE o.securityCode = :securityCode"),
    @NamedQuery(name = "Onlinepayment.findByDuedate", query = "SELECT o FROM Onlinepayment o WHERE o.duedate = :duedate")})
public class Onlinepayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "onlinePaymentId")
    private Integer onlinePaymentId;
    @Basic(optional = false)
    @Column(name = "creditCartNo")
    private int creditCartNo;
    @Basic(optional = false)
    @Column(name = "CartOwnerName")
    private String cartOwnerName;
    @Basic(optional = false)
    @Column(name = "SecurityCode")
    private int securityCode;
    @Basic(optional = false)
    @Column(name = "duedate")
    private String duedate;
    @JoinColumn(name = "payment\u0131d", referencedColumnName = "paymentId")
    @ManyToOne(optional = false)
    private Payment paymentıd;

    public Onlinepayment() {
    }

    public Onlinepayment(Integer onlinePaymentId) {
        this.onlinePaymentId = onlinePaymentId;
    }

    public Onlinepayment(Integer onlinePaymentId, int creditCartNo, String cartOwnerName, int securityCode, String duedate) {
        this.onlinePaymentId = onlinePaymentId;
        this.creditCartNo = creditCartNo;
        this.cartOwnerName = cartOwnerName;
        this.securityCode = securityCode;
        this.duedate = duedate;
    }

    public Integer getOnlinePaymentId() {
        return onlinePaymentId;
    }

    public void setOnlinePaymentId(Integer onlinePaymentId) {
        this.onlinePaymentId = onlinePaymentId;
    }

    public int getCreditCartNo() {
        return creditCartNo;
    }

    public void setCreditCartNo(int creditCartNo) {
        this.creditCartNo = creditCartNo;
    }

    public String getCartOwnerName() {
        return cartOwnerName;
    }

    public void setCartOwnerName(String cartOwnerName) {
        this.cartOwnerName = cartOwnerName;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public Payment getPaymentıd() {
        return paymentıd;
    }

    public void setPaymentıd(Payment paymentıd) {
        this.paymentıd = paymentıd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (onlinePaymentId != null ? onlinePaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onlinepayment)) {
            return false;
        }
        Onlinepayment other = (Onlinepayment) object;
        if ((this.onlinePaymentId == null && other.onlinePaymentId != null) || (this.onlinePaymentId != null && !this.onlinePaymentId.equals(other.onlinePaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Onlinepayment[ onlinePaymentId=" + onlinePaymentId + " ]";
    }
    
}

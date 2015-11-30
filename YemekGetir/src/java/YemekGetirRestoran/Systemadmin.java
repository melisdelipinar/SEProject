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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xxxxxxxxx
 */
@Entity
@Table(name = "systemadmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemadmin.findAll", query = "SELECT s FROM Systemadmin s"),
    @NamedQuery(name = "Systemadmin.findBySystemAdminId", query = "SELECT s FROM Systemadmin s WHERE s.systemAdminId = :systemAdminId"),
    @NamedQuery(name = "Systemadmin.findByFname", query = "SELECT s FROM Systemadmin s WHERE s.fname = :fname"),
    @NamedQuery(name = "Systemadmin.findByEmail", query = "SELECT s FROM Systemadmin s WHERE s.email = :email"),
    @NamedQuery(name = "Systemadmin.findByPassword", query = "SELECT s FROM Systemadmin s WHERE s.password = :password"),
    @NamedQuery(name = "Systemadmin.findByLname", query = "SELECT s FROM Systemadmin s WHERE s.lname = :lname")})
public class Systemadmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SystemAdminId")
    private Integer systemAdminId;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;

    public Systemadmin() {
    }

    public Systemadmin(Integer systemAdminId) {
        this.systemAdminId = systemAdminId;
    }

    public Systemadmin(Integer systemAdminId, String fname, String email, String password, String lname) {
        this.systemAdminId = systemAdminId;
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.lname = lname;
    }

    public Integer getSystemAdminId() {
        return systemAdminId;
    }

    public void setSystemAdminId(Integer systemAdminId) {
        this.systemAdminId = systemAdminId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemAdminId != null ? systemAdminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemadmin)) {
            return false;
        }
        Systemadmin other = (Systemadmin) object;
        if ((this.systemAdminId == null && other.systemAdminId != null) || (this.systemAdminId != null && !this.systemAdminId.equals(other.systemAdminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Systemadmin[ systemAdminId=" + systemAdminId + " ]";
    }
    
}

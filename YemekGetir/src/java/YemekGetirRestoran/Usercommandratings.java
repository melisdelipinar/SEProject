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
@Table(name = "usercommandratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercommandratings.findAll", query = "SELECT u FROM Usercommandratings u"),
    @NamedQuery(name = "Usercommandratings.findByCommentId", query = "SELECT u FROM Usercommandratings u WHERE u.commentId = :commentId"),
    @NamedQuery(name = "Usercommandratings.findByComment", query = "SELECT u FROM Usercommandratings u WHERE u.comment = :comment"),
    @NamedQuery(name = "Usercommandratings.findByRating", query = "SELECT u FROM Usercommandratings u WHERE u.rating = :rating")})
public class Usercommandratings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "commentId")
    private Integer commentId;
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;
    @JoinColumn(name = "userId", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
    @ManyToOne(optional = false)
    private Restaurant restaurantId;

    public Usercommandratings() {
    }

    public Usercommandratings(Integer commentId) {
        this.commentId = commentId;
    }

    public Usercommandratings(Integer commentId, String comment, int rating) {
        this.commentId = commentId;
        this.comment = comment;
        this.rating = rating;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercommandratings)) {
            return false;
        }
        Usercommandratings other = (Usercommandratings) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Usercommandratings[ commentId=" + commentId + " ]";
    }
    
}

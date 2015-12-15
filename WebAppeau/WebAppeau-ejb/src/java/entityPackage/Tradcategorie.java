/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "TRADCATEGORIE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Tradcategorie.findAll", query = "SELECT t FROM Tradcategorie t"),
    @NamedQuery(name = "Tradcategorie.findById", query = "SELECT t FROM Tradcategorie t WHERE t.id = :id"),
    @NamedQuery(name = "Tradcategorie.findByTradnom", query = "SELECT t FROM Tradcategorie t WHERE t.tradnom = :tradnom"),
    @NamedQuery(name = "Tradcategorie.getAllTraduction", query = "SELECT t from Tradcategorie t WHERE t.idlangue = :idlang"),
    @NamedQuery(name = "Tradcategorie.getTraduction", query = "SELECT t from Tradcategorie t WHERE t.idlangue = :idlang AND t.idcategorie = :idcat")})
public class Tradcategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 256)
    @Column(name = "TRADNOM")
    private String tradnom;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "ID")
    @ManyToOne
    private Categorie idcategorie;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "ID")
    @ManyToOne
    private Langue idlangue;

    public Tradcategorie() {
    }

    public Tradcategorie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradnom() {
        return tradnom;
    }

    public void setTradnom(String tradnom) {
        this.tradnom = tradnom;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Langue getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Langue idlangue) {
        this.idlangue = idlangue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradcategorie)) {
            return false;
        }
        Tradcategorie other = (Tradcategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Tradcategorie[ id=" + id + " ]";
    }
    
}

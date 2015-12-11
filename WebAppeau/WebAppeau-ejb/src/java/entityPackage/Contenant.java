/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "CONTENANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenant.findAll", query = "SELECT c FROM Contenant c"),
    @NamedQuery(name = "Contenant.findById", query = "SELECT c FROM Contenant c WHERE c.id = :id"),
    @NamedQuery(name = "Contenant.findByPrixappeaux", query = "SELECT c FROM Contenant c WHERE c.prixappeaux = :prixappeaux"),
    @NamedQuery(name = "Contenant.findByQuantit\u00e9", query = "SELECT c FROM Contenant c WHERE c.quantit\u00e9 = :quantit\u00e9")})
public class Contenant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIXAPPEAUX")
    private BigDecimal prixappeaux;
    @Column(name = "QUANTIT\u00c9")
    private Integer quantité;
    @OneToMany(mappedBy = "idcont")
    private Collection<Commande> commandeCollection;

    public Contenant() {
    }

    public Contenant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrixappeaux() {
        return prixappeaux;
    }

    public void setPrixappeaux(BigDecimal prixappeaux) {
        this.prixappeaux = prixappeaux;
    }

    public Integer getQuantité() {
        return quantité;
    }

    public void setQuantité(Integer quantité) {
        this.quantité = quantité;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
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
        if (!(object instanceof Contenant)) {
            return false;
        }
        Contenant other = (Contenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Contenant[ id=" + id + " ]";
    }
    
}

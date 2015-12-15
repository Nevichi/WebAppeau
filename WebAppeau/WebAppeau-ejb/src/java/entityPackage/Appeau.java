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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "APPEAU")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Appeau.findAll", query = "SELECT a FROM Appeau a"),
    @NamedQuery(name = "Appeau.findById", query = "SELECT a FROM Appeau a WHERE a.id = :id"),
    @NamedQuery(name = "Appeau.findByPrix", query = "SELECT a FROM Appeau a WHERE a.prix = :prix"),
    @NamedQuery(name = "Appeau.findByNom", query = "SELECT a FROM Appeau a WHERE a.nom = :nom"),
    @NamedQuery(name = "Appeau.findByUrlimage", query = "SELECT a FROM Appeau a WHERE a.urlimage = :urlimage"),
    @NamedQuery(name = "Appeau.findByAnimal", query = "SELECT a FROM Appeau a, Animal c WHERE a.idanimal = :idan AND :idan = c")})
public class Appeau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX")
    private BigDecimal prix;
    @Size(max = 256)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 256)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @JoinColumn(name = "IDANIMAL", referencedColumnName = "ID")
    @ManyToOne
    private Animal idanimal;
    @OneToMany(mappedBy = "idappeau")
    private Collection<Contenant> contenantCollection;

    public Appeau() {
    }

    public Appeau(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Animal getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(Animal idanimal) {
        this.idanimal = idanimal;
    }

    @XmlTransient
    public Collection<Contenant> getContenantCollection() {
        return contenantCollection;
    }

    public void setContenantCollection(Collection<Contenant> contenantCollection) {
        this.contenantCollection = contenantCollection;
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
        if (!(object instanceof Appeau)) {
            return false;
        }
        Appeau other = (Appeau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Appeau[ id=" + id + " ]";
    }
    
}

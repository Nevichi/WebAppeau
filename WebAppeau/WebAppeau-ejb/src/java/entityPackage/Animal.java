/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "ANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findById", query = "SELECT a FROM Animal a WHERE a.id = :id"),
    @NamedQuery(name = "Animal.findByNom", query = "SELECT a FROM Animal a WHERE a.nom = :nom"),
    @NamedQuery(name = "Animal.findByDated\u00e9butchasse", query = "SELECT a FROM Animal a WHERE a.dated\u00e9butchasse = :dated\u00e9butchasse"),
    @NamedQuery(name = "Animal.findByDatefinchasse", query = "SELECT a FROM Animal a WHERE a.datefinchasse = :datefinchasse"),
    @NamedQuery(name = "Animal.findByUrlimage", query = "SELECT a FROM Animal a WHERE a.urlimage = :urlimage"),
    @NamedQuery(name = "Animal.findByCategorie", query = "SELECT a FROM Animal a, Categorie c WHERE a.idcategorie = :idcat AND :idcat = c")})
public class Animal implements Serializable {
    @OneToMany(mappedBy = "idanimal")
    private Collection<Tradanimal> tradanimalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 256)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "DATED\u00c9BUTCHASSE")
    @Temporal(TemporalType.DATE)
    private Date datedébutchasse;
    @Column(name = "DATEFINCHASSE")
    @Temporal(TemporalType.DATE)
    private Date datefinchasse;
    @Size(max = 256)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "ID")
    @ManyToOne
    private Categorie idcategorie;
    @OneToMany(mappedBy = "idanimal")
    private Collection<Appeau> appeauCollection;

    public Animal() {
    }

    public Animal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedébutchasse() {
        return datedébutchasse;
    }

    public void setDatedébutchasse(Date datedébutchasse) {
        this.datedébutchasse = datedébutchasse;
    }

    public Date getDatefinchasse() {
        return datefinchasse;
    }

    public void setDatefinchasse(Date datefinchasse) {
        this.datefinchasse = datefinchasse;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    @XmlTransient
    public Collection<Appeau> getAppeauCollection() {
        return appeauCollection;
    }

    public void setAppeauCollection(Collection<Appeau> appeauCollection) {
        this.appeauCollection = appeauCollection;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Animal[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Tradanimal> getTradanimalCollection() {
        return tradanimalCollection;
    }

    public void setTradanimalCollection(Collection<Tradanimal> tradanimalCollection) {
        this.tradanimalCollection = tradanimalCollection;
    }
    
}

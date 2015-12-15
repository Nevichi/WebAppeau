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
@Table(name = "TRADANIMAL")
@XmlRootElement
@NamedQueries({
       @NamedQuery(name = "Tradanimal.findAll", query = "SELECT t FROM Tradanimal t"),
    @NamedQuery(name = "Tradanimal.findById", query = "SELECT t FROM Tradanimal t WHERE t.id = :id"),
    @NamedQuery(name = "Tradanimal.findByNom", query = "SELECT t FROM Tradanimal t WHERE t.nom = :nom"),
    @NamedQuery(name = "Tradanimal.getAnimalTrad", query = "SELECT t FROM Tradanimal t WHERE t.idlangue = :idlang AND t.idanimal = :idan"),
    @NamedQuery(name = "Tradanimal.search", query = "SELECT t FROM Tradanimal t WHERE t.nom like :item AND t.idlangue = :idlang")})
public class Tradanimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 256)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "IDANIMAL", referencedColumnName = "ID")
    @ManyToOne
    private Animal idanimal;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "ID")
    @ManyToOne
    private Langue idlangue;

    public Tradanimal() {
    }

    public Tradanimal(Integer id) {
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

    public Animal getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(Animal idanimal) {
        this.idanimal = idanimal;
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
        if (!(object instanceof Tradanimal)) {
            return false;
        }
        Tradanimal other = (Tradanimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Tradanimal[ id=" + id + " ]";
    }
    
}

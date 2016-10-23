/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZO-PC
 */
@Entity
@Table(name = "Produit", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByReference", query = "SELECT p FROM Produit p WHERE p.reference = :reference"),
    @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation"),
    @NamedQuery(name = "Produit.findByQuantiteEnStock", query = "SELECT p FROM Produit p WHERE p.quantiteEnStock = :quantiteEnStock"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reference", nullable = false, length = 20)
    private String reference;
    @Column(name = "designation", length = 100)
    private String designation;
    @Column(name = "quantiteEnStock")
    private Integer quantiteEnStock;
    @Column(name = "prix")
    private Integer prix;
    @OneToMany(mappedBy = "reference")
    private List<PanierCommande> panierCommandeList;
    @JoinColumn(name = "idFamille", referencedColumnName = "idFamille")
    @ManyToOne
    private FamilleProduit idFamille;

    public Produit() {
    }

    public Produit(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(Integer quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @XmlTransient
    public List<PanierCommande> getPanierCommandeList() {
        return panierCommandeList;
    }

    public void setPanierCommandeList(List<PanierCommande> panierCommandeList) {
        this.panierCommandeList = panierCommandeList;
    }

    public FamilleProduit getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(FamilleProduit idFamille) {
        this.idFamille = idFamille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.Produit[ reference=" + reference + " ]";
    }
    
}

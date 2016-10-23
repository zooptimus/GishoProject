/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.model.entity;

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
 * @author ZO-PC
 */
@Entity
@Table(name = "PanierCommande", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PanierCommande.findAll", query = "SELECT p FROM PanierCommande p"),
    @NamedQuery(name = "PanierCommande.findByIdPanierCommande", query = "SELECT p FROM PanierCommande p WHERE p.idPanierCommande = :idPanierCommande"),
    @NamedQuery(name = "PanierCommande.findByQuantite", query = "SELECT p FROM PanierCommande p WHERE p.quantite = :quantite")})
public class PanierCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPanierCommande", nullable = false)
    private Integer idPanierCommande;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "idCommande", referencedColumnName = "idCommande")
    @ManyToOne
    private Commande idCommande;
    @JoinColumn(name = "idPanier", referencedColumnName = "idPanier")
    @ManyToOne
    private Panier idPanier;
    @JoinColumn(name = "reference", referencedColumnName = "reference")
    @ManyToOne
    private Produit reference;

    public PanierCommande() {
    }

    public PanierCommande(Integer idPanierCommande) {
        this.idPanierCommande = idPanierCommande;
    }

    public Integer getIdPanierCommande() {
        return idPanierCommande;
    }

    public void setIdPanierCommande(Integer idPanierCommande) {
        this.idPanierCommande = idPanierCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Panier getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Panier idPanier) {
        this.idPanier = idPanier;
    }

    public Produit getReference() {
        return reference;
    }

    public void setReference(Produit reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPanierCommande != null ? idPanierCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PanierCommande)) {
            return false;
        }
        PanierCommande other = (PanierCommande) object;
        if ((this.idPanierCommande == null && other.idPanierCommande != null) || (this.idPanierCommande != null && !this.idPanierCommande.equals(other.idPanierCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.PanierCommande[ idPanierCommande=" + idPanierCommande + " ]";
    }
    
}

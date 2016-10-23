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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZO-PC
 */
@Entity
@Table(name = "Panier", catalog = "Gisho", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idConsommateur"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panier.findAll", query = "SELECT p FROM Panier p"),
    @NamedQuery(name = "Panier.findByIdPanier", query = "SELECT p FROM Panier p WHERE p.idPanier = :idPanier"),
    @NamedQuery(name = "Panier.findByNombreArticle", query = "SELECT p FROM Panier p WHERE p.nombreArticle = :nombreArticle"),
    @NamedQuery(name = "Panier.findByTotal", query = "SELECT p FROM Panier p WHERE p.total = :total")})
public class Panier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPanier", nullable = false)
    private Integer idPanier;
    @Column(name = "nombreArticle")
    private Integer nombreArticle;
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "idConsommateur", referencedColumnName = "idConsommateur", nullable = false)
    @OneToOne(optional = false)
    private Consommateur idConsommateur;
    @OneToMany(mappedBy = "idPanier")
    private List<PanierCommande> panierCommandeList;

    public Panier() {
    }

    public Panier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Integer getNombreArticle() {
        return nombreArticle;
    }

    public void setNombreArticle(Integer nombreArticle) {
        this.nombreArticle = nombreArticle;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Consommateur getIdConsommateur() {
        return idConsommateur;
    }

    public void setIdConsommateur(Consommateur idConsommateur) {
        this.idConsommateur = idConsommateur;
    }

    @XmlTransient
    public List<PanierCommande> getPanierCommandeList() {
        return panierCommandeList;
    }

    public void setPanierCommandeList(List<PanierCommande> panierCommandeList) {
        this.panierCommandeList = panierCommandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPanier != null ? idPanier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panier)) {
            return false;
        }
        Panier other = (Panier) object;
        if ((this.idPanier == null && other.idPanier != null) || (this.idPanier != null && !this.idPanier.equals(other.idPanier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.Panier[ idPanier=" + idPanier + " ]";
    }
    
}

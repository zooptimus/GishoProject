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
@Table(name = "FamilleProduit", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilleProduit.findAll", query = "SELECT f FROM FamilleProduit f"),
    @NamedQuery(name = "FamilleProduit.findByIdFamille", query = "SELECT f FROM FamilleProduit f WHERE f.idFamille = :idFamille"),
    @NamedQuery(name = "FamilleProduit.findByNomFamille", query = "SELECT f FROM FamilleProduit f WHERE f.nomFamille = :nomFamille")})
public class FamilleProduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFamille", nullable = false)
    private Integer idFamille;
    @Column(name = "nomFamille", length = 50)
    private String nomFamille;
    @OneToMany(mappedBy = "idFamille")
    private List<DistributeurFamille> distributeurFamilleList;
    @OneToMany(mappedBy = "idFamille")
    private List<Produit> produitList;

    public FamilleProduit() {
    }

    public FamilleProduit(Integer idFamille) {
        this.idFamille = idFamille;
    }

    public Integer getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(Integer idFamille) {
        this.idFamille = idFamille;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    @XmlTransient
    public List<DistributeurFamille> getDistributeurFamilleList() {
        return distributeurFamilleList;
    }

    public void setDistributeurFamilleList(List<DistributeurFamille> distributeurFamilleList) {
        this.distributeurFamilleList = distributeurFamilleList;
    }

    @XmlTransient
    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamille != null ? idFamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamilleProduit)) {
            return false;
        }
        FamilleProduit other = (FamilleProduit) object;
        if ((this.idFamille == null && other.idFamille != null) || (this.idFamille != null && !this.idFamille.equals(other.idFamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.FamilleProduit[ idFamille=" + idFamille + " ]";
    }
    
}

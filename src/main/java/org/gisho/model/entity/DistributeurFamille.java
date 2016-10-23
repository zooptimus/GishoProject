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
@Table(name = "DistributeurFamille", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DistributeurFamille.findAll", query = "SELECT d FROM DistributeurFamille d"),
    @NamedQuery(name = "DistributeurFamille.findByIdDistributeurProduit", query = "SELECT d FROM DistributeurFamille d WHERE d.idDistributeurProduit = :idDistributeurProduit")})
public class DistributeurFamille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDistributeurProduit", nullable = false)
    private Integer idDistributeurProduit;
    @JoinColumn(name = "idDistributeur", referencedColumnName = "idDistributeur")
    @ManyToOne
    private Distributeur idDistributeur;
    @JoinColumn(name = "idFamille", referencedColumnName = "idFamille")
    @ManyToOne
    private FamilleProduit idFamille;

    public DistributeurFamille() {
    }

    public DistributeurFamille(Integer idDistributeurProduit) {
        this.idDistributeurProduit = idDistributeurProduit;
    }

    public Integer getIdDistributeurProduit() {
        return idDistributeurProduit;
    }

    public void setIdDistributeurProduit(Integer idDistributeurProduit) {
        this.idDistributeurProduit = idDistributeurProduit;
    }

    public Distributeur getIdDistributeur() {
        return idDistributeur;
    }

    public void setIdDistributeur(Distributeur idDistributeur) {
        this.idDistributeur = idDistributeur;
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
        hash += (idDistributeurProduit != null ? idDistributeurProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistributeurFamille)) {
            return false;
        }
        DistributeurFamille other = (DistributeurFamille) object;
        if ((this.idDistributeurProduit == null && other.idDistributeurProduit != null) || (this.idDistributeurProduit != null && !this.idDistributeurProduit.equals(other.idDistributeurProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.DistributeurFamille[ idDistributeurProduit=" + idDistributeurProduit + " ]";
    }
    
}

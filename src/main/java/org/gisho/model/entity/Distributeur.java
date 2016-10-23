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
@Table(name = "Distributeur", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distributeur.findAll", query = "SELECT d FROM Distributeur d"),
    @NamedQuery(name = "Distributeur.findByIdDistributeur", query = "SELECT d FROM Distributeur d WHERE d.idDistributeur = :idDistributeur"),
    @NamedQuery(name = "Distributeur.findByEnseigne", query = "SELECT d FROM Distributeur d WHERE d.enseigne = :enseigne"),
    @NamedQuery(name = "Distributeur.findByNomDistributeur", query = "SELECT d FROM Distributeur d WHERE d.nomDistributeur = :nomDistributeur"),
    @NamedQuery(name = "Distributeur.findByAdresseDistributeur", query = "SELECT d FROM Distributeur d WHERE d.adresseDistributeur = :adresseDistributeur"),
    @NamedQuery(name = "Distributeur.findByVilleDistributeur", query = "SELECT d FROM Distributeur d WHERE d.villeDistributeur = :villeDistributeur"),
    @NamedQuery(name = "Distributeur.findByEmailDistributeur", query = "SELECT d FROM Distributeur d WHERE d.emailDistributeur = :emailDistributeur")})
public class Distributeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDistributeur", nullable = false)
    private Integer idDistributeur;
    @Column(name = "enseigne", length = 50)
    private String enseigne;
    @Column(name = "nomDistributeur", length = 100)
    private String nomDistributeur;
    @Column(name = "adresseDistributeur", length = 100)
    private String adresseDistributeur;
    @Column(name = "villeDistributeur", length = 50)
    private String villeDistributeur;
    @Column(name = "emailDistributeur", length = 100)
    private String emailDistributeur;
    @OneToMany(mappedBy = "idDistributeur")
    private List<DistributeurFamille> distributeurFamilleList;

    public Distributeur() {
    }

    public Distributeur(Integer idDistributeur) {
        this.idDistributeur = idDistributeur;
    }

    public Integer getIdDistributeur() {
        return idDistributeur;
    }

    public void setIdDistributeur(Integer idDistributeur) {
        this.idDistributeur = idDistributeur;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getNomDistributeur() {
        return nomDistributeur;
    }

    public void setNomDistributeur(String nomDistributeur) {
        this.nomDistributeur = nomDistributeur;
    }

    public String getAdresseDistributeur() {
        return adresseDistributeur;
    }

    public void setAdresseDistributeur(String adresseDistributeur) {
        this.adresseDistributeur = adresseDistributeur;
    }

    public String getVilleDistributeur() {
        return villeDistributeur;
    }

    public void setVilleDistributeur(String villeDistributeur) {
        this.villeDistributeur = villeDistributeur;
    }

    public String getEmailDistributeur() {
        return emailDistributeur;
    }

    public void setEmailDistributeur(String emailDistributeur) {
        this.emailDistributeur = emailDistributeur;
    }

    @XmlTransient
    public List<DistributeurFamille> getDistributeurFamilleList() {
        return distributeurFamilleList;
    }

    public void setDistributeurFamilleList(List<DistributeurFamille> distributeurFamilleList) {
        this.distributeurFamilleList = distributeurFamilleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistributeur != null ? idDistributeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distributeur)) {
            return false;
        }
        Distributeur other = (Distributeur) object;
        if ((this.idDistributeur == null && other.idDistributeur != null) || (this.idDistributeur != null && !this.idDistributeur.equals(other.idDistributeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.Distributeur[ idDistributeur=" + idDistributeur + " ]";
    }
    
}

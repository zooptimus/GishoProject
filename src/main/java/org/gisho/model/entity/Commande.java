/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZO-PC
 */
@Entity
@Table(name = "Commande", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande"),
    @NamedQuery(name = "Commande.findByValide", query = "SELECT c FROM Commande c WHERE c.valide = :valide")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCommande", nullable = false, length = 20)
    private String idCommande;
    @Basic(optional = false)
    @Column(name = "dateCommande", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Basic(optional = false)
    @Column(name = "valide", nullable = false)
    private boolean valide;
    @OneToMany(mappedBy = "idCommande")
    private List<PanierCommande> panierCommandeList;
    @JoinColumn(name = "idConsommateur", referencedColumnName = "idConsommateur", nullable = false)
    @ManyToOne(optional = false)
    private Consommateur idConsommateur;
    @OneToMany(mappedBy = "idCommande")
    private List<Livraison> livraisonList;

    public Commande() {
    }

    public Commande(String idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(String idCommande, Date dateCommande, boolean valide) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.valide = valide;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean getValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    @XmlTransient
    public List<PanierCommande> getPanierCommandeList() {
        return panierCommandeList;
    }

    public void setPanierCommandeList(List<PanierCommande> panierCommandeList) {
        this.panierCommandeList = panierCommandeList;
    }

    public Consommateur getIdConsommateur() {
        return idConsommateur;
    }

    public void setIdConsommateur(Consommateur idConsommateur) {
        this.idConsommateur = idConsommateur;
    }

    @XmlTransient
    public List<Livraison> getLivraisonList() {
        return livraisonList;
    }

    public void setLivraisonList(List<Livraison> livraisonList) {
        this.livraisonList = livraisonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.Commande[ idCommande=" + idCommande + " ]";
    }
    
}

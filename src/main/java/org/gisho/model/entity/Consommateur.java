/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZO-PC
 */
@Entity
@Table(name = "Consommateur", catalog = "Gisho", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consommateur.findAll", query = "SELECT c FROM Consommateur c"),
    @NamedQuery(name = "Consommateur.findByIdConsommateur", query = "SELECT c FROM Consommateur c WHERE c.idConsommateur = :idConsommateur"),
    @NamedQuery(name = "Consommateur.findByNomConsommateur", query = "SELECT c FROM Consommateur c WHERE c.nomConsommateur = :nomConsommateur"),
    @NamedQuery(name = "Consommateur.findByPrenomConsommateur", query = "SELECT c FROM Consommateur c WHERE c.prenomConsommateur = :prenomConsommateur"),
    @NamedQuery(name = "Consommateur.findByAdresseConsommateur", query = "SELECT c FROM Consommateur c WHERE c.adresseConsommateur = :adresseConsommateur"),
    @NamedQuery(name = "Consommateur.findByVilleConsommateur", query = "SELECT c FROM Consommateur c WHERE c.villeConsommateur = :villeConsommateur"),
    @NamedQuery(name = "Consommateur.findByLocalisationConsommateur", query = "SELECT c FROM Consommateur c WHERE c.localisationConsommateur = :localisationConsommateur"),
    @NamedQuery(name = "Consommateur.findByEmailConsomateur", query = "SELECT c FROM Consommateur c WHERE c.emailConsomateur = :emailConsomateur")})
public class Consommateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idConsommateur", nullable = false)
    private Integer idConsommateur;
    @Basic(optional = false)
    @Column(name = "nomConsommateur", nullable = false, length = 50)
    private String nomConsommateur;
    @Column(name = "prenomConsommateur", length = 30)
    private String prenomConsommateur;
    @Basic(optional = false)
    @Column(name = "adresseConsommateur", nullable = false, length = 150)
    private String adresseConsommateur;
    @Basic(optional = false)
    @Column(name = "villeConsommateur", nullable = false, length = 50)
    private String villeConsommateur;
    @Basic(optional = false)
    @Column(name = "localisationConsommateur", nullable = false, length = 20)
    private String localisationConsommateur;
    @Column(name = "emailConsomateur", length = 50)
    private String emailConsomateur;
    @Column(name = "motdepasse", length = 10)
    private String password;
    @Column(name = "login", length = 20)
    private String login;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idConsommateur")
    private Panier panier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsommateur")
    private List<Commande> commandeList;

    /**
     * FACEBOOK ELEMENTS *
     */
    @Column(name = FACEBOOK_ID, length = 500)
    private String facebookId;
    public static final String FACEBOOK_ID = "facebook_id";

    @Column(name = FACEBOOK_IMAGE, length = 500)
    private String facebookImage;
    public static final String FACEBOOK_IMAGE = "facebook_image";

    public Consommateur() {
    }

    public Consommateur(Integer idConsommateur) {
        this.idConsommateur = idConsommateur;
    }

    public Consommateur(Integer idConsommateur, String nomConsommateur, String adresseConsommateur, String villeConsommateur, String localisationConsommateur) {
        this.idConsommateur = idConsommateur;
        this.nomConsommateur = nomConsommateur;
        this.adresseConsommateur = adresseConsommateur;
        this.villeConsommateur = villeConsommateur;
        this.localisationConsommateur = localisationConsommateur;
    }

    public Integer getIdConsommateur() {
        return idConsommateur;
    }

    public void setIdConsommateur(Integer idConsommateur) {
        this.idConsommateur = idConsommateur;
    }

    public String getNomConsommateur() {
        return nomConsommateur;
    }

    public void setNomConsommateur(String nomConsommateur) {
        this.nomConsommateur = nomConsommateur;
    }

    public String getPrenomConsommateur() {
        return prenomConsommateur;
    }

    public void setPrenomConsommateur(String prenomConsommateur) {
        this.prenomConsommateur = prenomConsommateur;
    }

    public String getAdresseConsommateur() {
        return adresseConsommateur;
    }

    public void setAdresseConsommateur(String adresseConsommateur) {
        this.adresseConsommateur = adresseConsommateur;
    }

    public String getVilleConsommateur() {
        return villeConsommateur;
    }

    public void setVilleConsommateur(String villeConsommateur) {
        this.villeConsommateur = villeConsommateur;
    }

    public String getLocalisationConsommateur() {
        return localisationConsommateur;
    }

    public void setLocalisationConsommateur(String localisationConsommateur) {
        this.localisationConsommateur = localisationConsommateur;
    }

    public String getEmailConsomateur() {
        return emailConsomateur;
    }

    public void setEmailConsomateur(String emailConsomateur) {
        this.emailConsomateur = emailConsomateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFacebookImage() {
        return facebookImage;
    }

    public void setFacebookImage(String facebookImage) {
        this.facebookImage = facebookImage;
    }
    
    

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public Commande addCommande(Commande commande) {
        getCommandeList().add(commande);
        commande.setIdConsommateur(this);

        return commande;
    }

    public Commande removeCommande(Commande commande) {
        getCommandeList().remove(commande);
        commande.setIdConsommateur(null);

        return commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsommateur != null ? idConsommateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consommateur)) {
            return false;
        }
        Consommateur other = (Consommateur) object;
        if ((this.idConsommateur == null && other.idConsommateur != null) || (this.idConsommateur != null && !this.idConsommateur.equals(other.idConsommateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testeee.Consommateur[ idConsommateur=" + idConsommateur + " ]";
    }

}

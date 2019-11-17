/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe représentant des contact.
 *
 * @author HP
 */
public class Contact {

    private String nom, prenom, tel, mail;
    private String numeroAppartement, rue, city, state, zip;

    /*
     * crée un objet contact
     * @param nom le nom du contact
     * @param prenom  le prenom du contact 
     * @param tel le numéro de téléphone du contact
     * @param mail le courriel du contact
     * @param numerAppartement le numero d 'appartement  du contact
     * @param rue le nom de rue  du contact
     * @param city la ville du contact
     * @param state province du contact
     * @param zip le code postal du contact
     */
    public Contact(String nom, String prenom, String tel, String mail, String numeroAppartement, String rue, String city, String state, String zip) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.numeroAppartement = numeroAppartement;
        this.rue = rue;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getNumeroAppartement() {
        return numeroAppartement;
    }

    public String getRue() {
        return rue;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumeroAppartement(String numeroAppartement) {
        this.numeroAppartement = numeroAppartement;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Contact{" + "nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", mail=" + mail + ", numeroAppartement=" + numeroAppartement + ", rue=" + rue + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
    }

}

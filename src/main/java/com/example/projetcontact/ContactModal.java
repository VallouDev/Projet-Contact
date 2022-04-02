package com.example.projetcontact;

public class ContactModal {

    public String nom;
    public String prenom;
    public String mail;
    public String CP ;
    public String adresse ;
    public String NTF;
    public String NTP ;


    public ContactModal(String nom, String prenom, String mail, String CP, String adresse, String NTF, String NTP) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.CP = CP;
        this.adresse = adresse;
        this.NTF = NTF;
        this.NTP = NTP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNTF() {
        return NTF;
    }

    public void setNTF(String NTF) {
        this.NTF = NTF;
    }

    public String getNTP() {
        return NTP;
    }

    public void setNTP(String NTP) {
        this.NTP = NTP;
    }
}

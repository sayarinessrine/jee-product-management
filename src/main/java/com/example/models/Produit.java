package com.example.models;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private int idcat;
    private String nomcat;
    public Produit(int id,String nom,double prix,int idcat,String nomcat){
        this.id=id;
        this.nom=nom;
        this.prix=prix;
        this.idcat=idcat;
        this.nomcat=nomcat;
    }
    public Produit(int id,String nom,double prix,int idcat){
        this.id=id;
        this.nom=nom;
        this.prix=prix;
        this.idcat=idcat;
    }
    public Produit(String nom,double prix,int idcat){
        this.nom=nom;
        this.prix=prix;
        this.idcat=idcat;
    }
    public Produit(int id,String nom,double prix){
        this.nom=nom;
        this.prix=prix;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }
}

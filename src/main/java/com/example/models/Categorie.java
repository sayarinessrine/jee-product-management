package com.example.models;



import java.sql.Date;

public class Categorie {
    private int id;
    private String nomcat;
    private Date date;

    public Categorie(int id, String  nomcat, Date date){
        this.id=id;
        this.nomcat=nomcat;
        this.date=date;
    }
    public Categorie(String nomcat, Date date){

        this.nomcat=nomcat;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


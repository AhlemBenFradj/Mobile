/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author hp
 */
public class Produit {
    private int IdP;
    private String NomProduit;
    private String Description;
    private double Prix;
    private int Quantite;
    private String Images;
    private String IdcP;
    private int Reports;

    public Produit(int IdP, String NomProduit, String Description, double Prix, int Quantite, String Images, String IdcP, int Reports) {
        this.IdP = IdP;
        this.NomProduit = NomProduit;
        this.Description = Description;
        this.Prix = Prix;
        this.Quantite = Quantite;
        this.Images = Images;
        this.IdcP = IdcP;
        this.Reports = Reports;
    }

    public Produit(String NomProduit, String Description, double Prix, int Quantite, String Images, String IdcP, int Reports) {
        this.NomProduit = NomProduit;
        this.Description = Description;
        this.Prix = Prix;
        this.Quantite = Quantite;
        this.Images = Images;
        this.IdcP = IdcP;
        this.Reports = Reports;
    }

    public Produit(String NomProduit, String Description, double Prix, int Quantite, String Images, String IdcP) {
        this.NomProduit = NomProduit;
        this.Description = Description;
        this.Prix = Prix;
        this.Quantite = Quantite;
        this.Images = Images;
        this.IdcP = IdcP;
    }

    public Produit() {
    }


    public int getIdP() {
        return IdP;
    }

    public void setIdP(int IdP) {
        this.IdP = IdP;
    }

    public String getNomProduit() {
        return NomProduit;
    }

    public void setNomProduit(String NomProduit) {
        this.NomProduit = NomProduit;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double Prix) {
        this.Prix = Prix;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    public String getIdcP() {
        return IdcP;
    }

    public void setIdcP(String IdcP) {
        this.IdcP = IdcP;
    }

    public int getReports() {
        return Reports;
    }

    public void setReports(int Reports) {
        this.Reports = Reports;
    }

    @Override
    public String toString() {
        return "Produit{" + "IdP=" + IdP + ", NomProduit=" + NomProduit + ", Description=" + Description + ", Prix=" + Prix + ", Quantite=" + Quantite + ", Images=" + Images + ", IdcP=" + IdcP + ", Reports=" + Reports + '}';
    }
    
    
}

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
public class Categorie {
    private int Idc;
    private String Description;

    public Categorie(int Idc, String Description) {
        this.Idc = Idc;
        this.Description = Description;
    }

    public Categorie(String Description) {
        this.Description = Description;
    }

    public Categorie() {
    }
    
    

    public int getIdc() {
        return Idc;
    }

    public void setIdc(int Idc) {
        this.Idc = Idc;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Categorie{" + "Idc=" + Idc + ", Description=" + Description + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author ALPHA
 */
public class Regimes {
    private int id;
    private String Titre,Description,ImgUml;

    public Regimes(int id, String Titre, String Description, String ImgUml) {
        this.id = id;
        this.Titre = Titre;
        this.Description = Description;
        this.ImgUml = ImgUml;
    }

    public Regimes(String Titre, String Description, String ImgUml) {
        this.Titre = Titre;
        this.Description = Description;
        this.ImgUml = ImgUml;
    }
    
    public Regimes() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImgUml() {
        return ImgUml;
    }

    public void setImgUml(String ImgUml) {
        this.ImgUml = ImgUml;
    }

    @Override
    public String toString() {
        return "Repas{" + "id=" + id + ", Titre=" + Titre + ", Description=" + Description + ", ImgUml=" + ImgUml + '}';
    }
    
}

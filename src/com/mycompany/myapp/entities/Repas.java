/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author ALPHA
 */
public class Repas {
    private int id,id_regime;
    private String Titre,Description,ImgUml;

    public Repas(int id, int id_regime, String Titre, String Description, String ImgUml) {
        this.id = id;
        this.id_regime = id_regime;
        this.Titre = Titre;
        this.Description = Description;
        this.ImgUml = ImgUml;
    }

    public Repas(int id_regime, String Titre, String Description, String ImgUml) {
        this.id_regime = id_regime;
        this.Titre = Titre;
        this.Description = Description;
        this.ImgUml = ImgUml;
    }
    
     public Repas(String Titre, String Description, String ImgUml) {
        this.Titre = Titre;
        this.Description = Description;
        this.ImgUml = ImgUml;
    }

    public Repas() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_regime() {
        return id_regime;
    }

    public void setId_regime(int id_regime) {
        this.id_regime = id_regime;
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
        return "Repas{" + "id=" + id + ", id_regime=" + id_regime + ", Titre=" + Titre + ", Description=" + Description + ", ImgUml=" + ImgUml + '}';
    }
    
}

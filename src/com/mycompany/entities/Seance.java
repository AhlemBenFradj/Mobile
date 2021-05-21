/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Seance {

    private int idseance;
    private String titreseance;
    private String descseance;
    private Date dateseance;
    private String idcoach;
    private int idroutine;
    private int likes;
    private String groupe;

    public int getIdseance() {
        return idseance;
    }

    @Override
    public String toString() {
        return "Seance{" + "titreseance=" + titreseance + ", descseance=" + descseance + ", dateseance=" + dateseance + ", idcoach=" + idcoach + ", idroutine=" + idroutine + ", likes=" + likes + ", groupe=" + groupe + "\n" +'}';
    }

    public Seance(String titreseance, String descseance, Date dateseance, String idcoach, int idroutine, int likes, String groupe) {
        this.titreseance = titreseance;
        this.descseance = descseance;
        this.dateseance = dateseance;
        this.idcoach = idcoach;
        this.idroutine = idroutine;
        this.likes = likes;
        this.groupe = groupe;
    }

    public Seance(int idseance, String titreseance, String descseance, Date dateseance, String idcoach, int idroutine, int likes, String groupe) {
        this.idseance = idseance;
        this.titreseance = titreseance;
        this.descseance = descseance;
        this.dateseance = dateseance;
        this.idcoach = idcoach;
        this.idroutine = idroutine;
        this.likes = likes;
        this.groupe = groupe;
    }

    public Seance() {
    }

    public void setIdseance(int idseance) {
        this.idseance = idseance;
    }

    public String getTitreseance() {
        return titreseance;
    }

    public void setTitreseance(String titreseance) {
        this.titreseance = titreseance;
    }

    public String getDescseance() {
        return descseance;
    }

    public void setDescseance(String descseance) {
        this.descseance = descseance;
    }

    public Date getDateseance() {
        return dateseance;
    }

    public void setDateseance(Date dateseance) {
        this.dateseance = dateseance;
    }

    public String getIdcoach() {
        return idcoach;
    }

    public void setIdcoach(String idcoach) {
        this.idcoach = idcoach;
    }

    public int getIdroutine() {
        return idroutine;
    }

    public void setIdroutine(int idroutine) {
        this.idroutine = idroutine;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

}

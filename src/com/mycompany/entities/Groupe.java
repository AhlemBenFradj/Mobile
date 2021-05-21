/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author USER
 */
public class Groupe {
    private int idclass;
    private String nomclass;
    private String typeclass;

    public Groupe(String nomclass, String typeclass) {
        this.nomclass = nomclass;
        this.typeclass = typeclass;
    }

    public Groupe(int idclass, String nomclass, String typeclass) {
        this.idclass = idclass;
        this.nomclass = nomclass;
        this.typeclass = typeclass;
    }

    public Groupe() {
    }

    @Override
    public String toString() {
        return "Groupe{" + "nomclass=" + nomclass + ", typeclass=" + typeclass +"\n"+ '}';
    }

    public int getIdclass() {
        return idclass;
    }

    public void setIdclass(int idclass) {
        this.idclass = idclass;
    }

    public String getNomclass() {
        return nomclass;
    }

    public void setNomclass(String nomclass) {
        this.nomclass = nomclass;
    }

    public String getTypeclass() {
        return typeclass;
    }

    public void setTypeclass(String typeclass) {
        this.typeclass = typeclass;
    }
}

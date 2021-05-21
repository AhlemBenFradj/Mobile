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
public class Participation {

    private int id;
    private String idclient;
    private String idcoach;
    private String status;
    private int idroutine;
    private Seance idseance;

    public Participation(int id, String idclient, String idcoach, String status, int idroutine, Seance idseance) {
        this.id = id;
        this.idclient = idclient;
        this.idcoach = idcoach;
        this.status = status;
        this.idroutine = idroutine;
        this.idseance = idseance;
    }

    public Participation(String idclient, String idcoach, String status, int idroutine, Seance idseance) {
        this.idclient = idclient;
        this.idcoach = idcoach;
        this.status = status;
        this.idroutine = idroutine;
        this.idseance = idseance;
    }

    public Participation() {
    }

    @Override
    public String toString() {
        return "Participation{" + "idclient=" + idclient + ", idcoach=" + idcoach + ", status=" + status + ", idroutine=" + idroutine + ", idseance=" + idseance + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public String getIdcoach() {
        return idcoach;
    }

    public void setIdcoach(String idcoach) {
        this.idcoach = idcoach;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdroutine() {
        return idroutine;
    }

    public void setIdroutine(int idroutine) {
        this.idroutine = idroutine;
    }

    public Seance getIdseance() {
        return idseance;
    }

    public void setIdseance(Seance idseance) {
        this.idseance = idseance;
    }

}

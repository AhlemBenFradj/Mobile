/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Seance;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceSeance {

    public ArrayList<Seance> seances;

    public static ServiceSeance instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceSeance() {
        req = new ConnectionRequest();
    }

    public static ServiceSeance getInstance() {
        if (instance == null) {
            instance = new ServiceSeance();
        }
        return instance;
    }

    public boolean addSeance(Seance t) {
        String url = Statics.BASE_URL + "/groupeadmin/addseancejson?titreSeance=" + t.getTitreseance() + "&descSeance=" + t.getDescseance() + "&dateSeance=" + t.getDateseance() + "&idcoach=" + t.getIdcoach() + "&idroutine=" + t.getIdroutine() + "&likes=" + t.getLikes() + "&groupe=" + t.getGroupe(); //création de l'URL
        System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("Groupe == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Seance> parseSeance(String jsonText) throws IOException {
        try {
            seances = new ArrayList<>();

            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> seanceListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(seanceListJson);

            List<Map<String, Object>> list = (List<Map<String, Object>>) seanceListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Seance t = new Seance();

                t.setTitreseance(obj.get("titreseance").toString());
                t.setDescseance(obj.get("titreseance").toString());
                t.setDateseance((Date) obj.get("dateseance"));
                t.setIdcoach(obj.get("idcoach").toString());
                t.setIdroutine((int) Float.parseFloat(obj.get("idroutine").toString()));
                t.setLikes(((int) Float.parseFloat(obj.get("likes").toString())));
                t.setGroupe(obj.get("groupe").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                seances.add(t);
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        return seances;
    }

    public ArrayList<Seance> getAllSeances() {
        String url = Statics.BASE_URL + "/groupeadmin/listeseances";
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponsejson = new String(req.getResponseData());

                try {
                    seances = parseSeance(reponsejson);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return seances;
    }

    public ArrayList<Seance> getSeance(int id) {
        String url = Statics.BASE_URL + "/seance/affichjson/" + id;
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponsejson = new String(req.getResponseData());

                try {
                    seances = parseSeance(reponsejson);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return seances;
    }
}

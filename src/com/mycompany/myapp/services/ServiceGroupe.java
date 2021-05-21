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
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Session;
import com.mycompany.myapp.entities.Groupe;
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
public class ServiceGroupe {

    public ArrayList<Groupe> groupes;

    public static ServiceGroupe instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceGroupe() {
        req = new ConnectionRequest();
    }

    public static ServiceGroupe getInstance() {
        if (instance == null) {
            instance = new ServiceGroupe();
        }
        return instance;
    }

    public boolean addGroupe(Groupe t) {
        String url = Statics.BASE_URL + "/groupeadmin/addgroupejson?nomClass=" + t.getNomclass() + "&typeClass=" + t.getTypeclass(); //création de l'URL
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

    public ArrayList<Groupe> parseGroupe(String jsonText) throws IOException {
        try {
            groupes = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> groupeListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(groupeListJson);
            List<Map<String, Object>> list = (List<Map<String, Object>>) groupeListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Groupe t = new Groupe();

                t.setNomclass(obj.get("nomclass").toString());
                t.setTypeclass(obj.get("typeclass").toString());

                //Ajouter la tâche extraite de la réponse Json à la liste
                groupes.add(t);
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        return groupes;
    }

    public ArrayList<Groupe> getAllGroupes() {
        String url = Statics.BASE_URL + "/groupeadmin/listegroupes";
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponsejson = new String(req.getResponseData());

                try {
                    groupes = parseGroupe(reponsejson);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return groupes;
    }

    public ArrayList<Groupe> getSeance(int id) {
        String url = Statics.BASE_URL + "/seance/affichjson/" + id;
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponsejson = new String(req.getResponseData());

                try {
                    groupes = parseGroupe(reponsejson);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return groupes;
    }

    public void like(int id) {
        String url = Statics.BASE_URL + "/groupeadmin/like/" + id;
        req.setUrl(url);
        req.setPost(false);
        System.out.println(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("Groupe == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;

    }

    public void participer(int id) {
        String url = Statics.BASE_URL + "/participation/newjson/" + id+"/"+Session.getCurrentSession().getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
              Dialog.show("Information", "Participé", new Command("OK"));
            System.out.println("Groupe == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;
    }

    public void annulerpartic(int id) {
        String url = Statics.BASE_URL + "/participation/" + id; 
        req.setUrl(url);
        req.setPost(false);
    }
}

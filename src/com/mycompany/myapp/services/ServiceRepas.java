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
import com.mycompany.entities.Repas;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServiceRepas {

    public ArrayList<Repas> tasks;
    
    public static ServiceRepas instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceRepas() {
         req = new ConnectionRequest();
    }

    public static ServiceRepas getInstance() {
        if (instance == null) {
            instance = new ServiceRepas();
        }
        return instance;
    }

    public boolean addRepas(Repas t) {
        String url = Statics.BASE_URL + "/JSON/Add_Rep?Titre=" + t.getTitre() + "&Description=" + t.getDescription()+ "&ImgUml=" + t.getImgUml(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Repas> parseRepas(String jsonText) throws IOException{
        ArrayList<Repas> list_cours=new ArrayList<Repas>();
       JSONParser j = new JSONParser();
       Map<String,Object> CoursListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)CoursListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Repas c=new Repas();
      
              int id = (int) Float.parseFloat(obj.get("id").toString());
        c.setId(id);
   
        
          c.setTitre(obj.get("titre").toString());
          c.setDescription(obj.get("description").toString());
          c.setImgUml(obj.get("imguml").toString());
        
          System.out.println(c);
     list_cours.add(c);
      }
      
      
       return list_cours;

    }
    
    
    public ArrayList<Repas> getAllRepas(){
        String url = Statics.BASE_URL+"/JSON/List_Rep";
        
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    tasks = parseRepas(new String(req.getResponseData()));
                } catch (IOException ex) {
               
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
}

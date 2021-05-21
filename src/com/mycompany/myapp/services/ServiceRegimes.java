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
import com.mycompany.myapp.entities.Regimes;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServiceRegimes {

    public ArrayList<Regimes> tasks;
    
    public static ServiceRegimes instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceRegimes() {
         req = new ConnectionRequest();
    }

    public static ServiceRegimes getInstance() {
        if (instance == null) {
            instance = new ServiceRegimes();
        }
        return instance;
    }

    public boolean addRegimes(Regimes t) {
        String url = Statics.BASE_URL1 + "/JSON/Add_Reg?Titre=" + t.getTitre() + "&Description=" + t.getDescription()+ "&ImgUml=" + t.getImgUml(); //création de l'URL
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

    public ArrayList<Regimes> parseRegimes(String jsonText) throws IOException{
        ArrayList<Regimes> list_cours=new ArrayList<Regimes>();
       JSONParser j = new JSONParser();
       Map<String,Object> CoursListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)CoursListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Regimes c=new Regimes();
      
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
    
    
    public ArrayList<Regimes> getAllRegimes(){
        String url = Statics.BASE_URL1+"/JSON/List_Reg";
        
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    tasks = parseRegimes(new String(req.getResponseData()));
                } catch (IOException ex) {
               
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
}

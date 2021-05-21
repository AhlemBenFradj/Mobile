/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.mycompany.entities.User;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.utils.Utils;
import java.util.ArrayList;
import com.codename1.io.JSONParser;
import java.util.Map;
import com.codename1.io.CharArrayReader;
import com.codename1.processing.Result;
import com.mycompany.entities.Compte;
import com.mycompany.entities.CompteAdmin;
import com.mycompany.entities.CompteClient;
import com.mycompany.entities.CompteCoach;
import com.mycompany.entities.Session;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class ServiceUser {

    public ArrayList<User> users;
    public Compte UserSession = new Compte();
//    public CompteAdmin compteAdmin = new CompteAdmin();
//    public CompteClient compteClient = new CompteClient();
//    public CompteCoach compteCoach = new CompteCoach();
 //   public String UserRole;
    public static ServiceUser instance = null;
    private ConnectionRequest req;
    
    public boolean resultOK;
    

    private ServiceUser() {
        req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
    public boolean addUser(Compte u,String role) {
        String url = Utils.BASE_URL + "/json/compte/new?" +"adresse="+ u.getAdresse() + "&password=" + u.getPassword() + "&nom=" + u.getNom() + "&prenom=" + u.getPrenom() + 
                "&telephone=" + u.getTelephone() + "&login=" + u.getLogin() + "&ville=" + u.getVille() + "&age=" + u.getAge() +
                "&email="+u.getEmail()+ "&roles="+ role +"&aboutMe="+u.getAboutMe()+"&imgurl="+u.getImgUrl() ;   
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
           
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }
        

     public boolean Update(Compte u) {
        String url = Utils.BASE_URL + "/json/compte/"+u.getId()+"/edit?" +"adresse="+ u.getAdresse() + "&password=" + u.getPassword() + "&nom=" + u.getNom() + "&prenom=" + u.getPrenom() + 
                "&telephone=" + u.getTelephone() + "&login=" + u.getLogin() + "&ville=" + u.getVille() + "&age=" + u.getAge() +
                "&email="+u.getEmail()+"&aboutMe="+u.getAboutMe() ;   
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {        
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;   
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }       
        
         public boolean UpdateClient(CompteClient u) {
        String url = Utils.BASE_URL + "/json/compteclient/"+Session.getCurrentSession().getId()+"/edit?" +"poids="+ u.getPoids()+ "&taille=" + u.getTaille() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {        
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;   
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }         

     
              public boolean UpdateCoach(CompteCoach u) {
        String url = Utils.BASE_URL + "/json/comptecoach/"+Session.getCurrentSession().getId()+"/edit?" +"prixHeure="+ u.getPrixHeure() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {        
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;   
                System.out.println("COACH UPDATED");
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }     
     
     
     
     
    public Compte Login(String username, String password) {
        String url = Utils.BASE_URL+"/json/utils/jsonlogin";
                HashMap hashtable = new HashMap ();
                hashtable.put("username", username);
                hashtable.put("password", password);
                final String payload = Result.fromContent(hashtable).toString();
        req.setUrl(url);
        req.setPost(true);
        req.setHttpMethod("POST");
        req.addRequestHeader("Content-Type","application/json");
        req.setRequestBody(payload);         
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                UserSession = parseUser(new String(req.getResponseData()));     
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return UserSession;
    }

    public Compte parseUser(String jsonText) {
        Compte compteL = new Compte();      
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                if (!UserListJson.isEmpty()) {                
                compteL.setLogin(UserListJson.get("login").toString());
                compteL.setId((int) Double.parseDouble(UserListJson.get("idcompte").toString()));
                compteL.setNom(UserListJson.get("nom").toString());
                compteL.setPrenom(UserListJson.get("prenom").toString());
                compteL.setPassword(UserListJson.get("password").toString());
                compteL.setEmail(UserListJson.get("email").toString());
                compteL.setVille(UserListJson.get("ville").toString());
                compteL.setAboutMe(UserListJson.get("aboutme").toString());
               compteL.setImgUrl("C:/Users/iheb/git/repositoryECorps/SecondLife/photos/300x300.jpg");
                compteL.setTelephone(UserListJson.get("telephone").toString());
                compteL.setAdresse(UserListJson.get("adresse").toString());
                compteL.setAge((int) Double.parseDouble(UserListJson.get("age").toString()));               
                compteL.toString();                
                switch (UserListJson.get("role").toString()) {
                    case "ROLE_COACH":
                        compteL.setRole("ROLE_COACH");
                        break;
                    case "ROLE_CLIENT":
                        compteL.setRole("ROLE_CLIENT");
                        break;
                    case "ROLE_ADMIN":
                         compteL.setRole("ROLE_ADMIN");             
                        break;
                    default:
                        break;
                }
            } else {
                return null;
            }
        } catch (IOException ex) {
        }
        return compteL;
    }
   public void setRole() {      
                switch (UserSession.getRole()) {
                    case "ROLE_COACH":
                        Session.getCurrentSession().setRole("ROLE_COACH");
                        break;
                    case "ROLE_CLIENT":
                        Session.getCurrentSession().setRole("ROLE_CLIENT");
                        break;
                    case "ROLE_ADMIN":
                        Session.getCurrentSession().setRole("ROLE_ADMIN");                
                        break;
                    default:
                        break;
                }         
    }
  public void refreshUser(){
      System.out.println("REFRESH HEADER");
      ConnectionRequest r = new ConnectionRequest ();
        String url = Utils.BASE_URL+"/json/compte/visite/"+Session.getCurrentSession().getId(); //session hné
        r.setPost(false);
        r.setUrl(url);      
        r.setHttpMethod("GET");
        r.addRequestHeader("Content-Type","application/json");
        r.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Compte c = new Compte();
                c = parseUser(new String(r.getResponseData())) ;
                System.out.println("ACTION TAAYTET");
                Session.start(c);  
                System.out.println("REFRESH RESPOND : "+parseUser(new String(r.getResponseData())).toString());
                r.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(r);
  } 

public void setExtras(){
    ConnectionRequest re = new ConnectionRequest();
    
    if (Session.getCurrentSession().getRole().equals("ROLE_COACH")) {
         String url = Utils.BASE_URL+"/json/comptecoach/visite/"+Session.getCurrentSession().getId(); //session hné
          re.setPost(false);
          re.setUrl(url);              
          re.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    CompteCoach c = new CompteCoach();
                    JSONParser j = new JSONParser();
                    Map<String, Object> UserListJson;               
                    UserListJson = j.parseJSON(new CharArrayReader(new String(re.getResponseData()).toCharArray()));
                    c.setPrixHeure((int) Double.parseDouble(UserListJson.get("prixheure").toString()));
                    Session.startCoach(c);
                re.removeResponseListener(this);
           } catch (IOException ex) {
                 //   Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
                }   }               
        });
        NetworkManager.getInstance().addToQueueAndWait(re);
        
    }  else if (Session.getCurrentSession().getRole().equals("ROLE_CLIENT")) {
          String url = Utils.BASE_URL+"/json/compteclient/visite/"+Session.getCurrentSession().getId(); //session hné
          re.setPost(false);
          re.setUrl(url);           
        re.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                 CompteClient c = new CompteClient();
                 JSONParser j = new JSONParser();
                 Map<String, Object> UserListJson;               
                 UserListJson = j.parseJSON(new CharArrayReader(new String(re.getResponseData()).toCharArray()));
                 c.setPoids((int) Double.parseDouble(UserListJson.get("poids").toString()));
                 c.setTaille((int) Double.parseDouble(UserListJson.get("taille").toString()));
                 Session.startClient(c);
                re.removeResponseListener(this);
           } catch (IOException ex) {
                 //   Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
                }   }               
        });
        NetworkManager.getInstance().addToQueueAndWait(re);
    } 
}
}

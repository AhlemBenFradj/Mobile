/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.Compte;
import com.mycompany.entities.Session;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.Home;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Welcome extends Form {

    Form current;

    public Welcome(Compte User, Resources res) {
        

        super("Profile", BoxLayout.y());
        current = this;
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);

        ServiceUser.getInstance().setExtras();
        ServiceUser.getInstance().refreshUser();
        
Button edit = new Button("Edition");
edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                      Toolbar.setGlobalToolbar(false);

                      new Update(Session.getCurrentSession(),res).show();  
                      System.out.println(User.toString());

                } catch (Exception ex) {
                 //   Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
Button Deconnection = new Button("Deconnection");
Deconnection.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                     Toolbar.setGlobalToolbar(true);
                       new Login(res).show();
                    Session.close();
                } catch (Exception ex) {
                 //   Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });



        tb.addSearchCommand(e -> {});
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        
         add(LayeredLayout.encloseIn(
              sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            Deconnection,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                            edit
                    )
                )
        ));
         
        
        
        TextField username = new TextField(Session.getCurrentSession().getLogin());
        username.setUIID("TextFieldBlack");
        addStringValue("Username", username);
        
        TextField email = new TextField(Session.getCurrentSession().getEmail());
        email.setUIID("TextFieldBlack");
        addStringValue("Email", email);
        
        TextField nom = new TextField(Session.getCurrentSession().getNom());
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom", nom);

        TextField prenom = new TextField(Session.getCurrentSession().getPrenom());
        prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom", prenom);

        TextField ville = new TextField(Session.getCurrentSession().getVille());
        ville.setUIID("TextFieldBlack");
        addStringValue("Ville", ville);

        TextField adresse = new TextField(Session.getCurrentSession().getAdresse());
        adresse.setUIID("TextFieldBlack");
        addStringValue("Adresse", adresse);

        TextField aboutme = new TextField(Session.getCurrentSession().getAboutMe());
        aboutme.setUIID("TextFieldBlack");
        addStringValue("About me", aboutme);
        
         TextField age = new TextField(String.valueOf(Session.getCurrentSession().getAge()));
        age.setUIID("TextFieldBlack");
        addStringValue("Age", age);

        TextField telephone = new TextField(String.valueOf(Session.getCurrentSession().getTelephone()));
        telephone.setUIID("TextFieldBlack");
        addStringValue("Telephone", telephone);
        
        
        if (Session.getCurrentSession().getRole().equals("ROLE_COACH")){
             TextField prixHeure = new TextField(String.valueOf(Session.getCurrentCoachSession().getPrixHeure()));
             prixHeure.setUIID("TextFieldBlack");
             addStringValue("PrixHeure", prixHeure);
        }
        
         if (Session.getCurrentSession().getRole().equals("ROLE_CLIENT")){
             TextField poids = new TextField(String.valueOf(Session.getCurrentClientSession().getPoids()));
             poids.setUIID("TextFieldBlack");
             addStringValue("Poids", poids);
             
              TextField taille = new TextField(String.valueOf(Session.getCurrentClientSession().getTaille()));
             taille.setUIID("TextFieldBlack");
             addStringValue("Taille", taille);
        }


       
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new Home(res).show());
        
        
        
        
    }
    
    
    
private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
       // add(createLineSeparator(0xeeeeee));
    }





}

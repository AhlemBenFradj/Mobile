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
import com.mycompany.entities.CompteClient;
import com.mycompany.entities.CompteCoach;
import com.mycompany.entities.Session;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
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
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
class Update extends Form {

    Form current;

    public Update(Compte User, Resources res) {

        super("Profile", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Update");
        getContentPane().setScrollVisible(false);

        tb.addSearchCommand(e -> {
        });

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Button retour = new Button("Retour");
        Button save = new Button("Save");
        
         add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(3,
                                save,
                             //   FlowLayout.encloseCenter(
                                new Label(""),
                                        //new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")), //profile pic here
                                retour
                        )
                )
        ));
        
        
        TextField email = new TextField(User.getEmail(), "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("Email", email);

        TextField nom = new TextField(User.getNom(), "Nom", 20, TextField.ANY);
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom", nom);

        TextField prenom = new TextField(User.getPrenom(), "Prenom", 20, TextField.ANY);
        prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom", prenom);

        TextField ville = new TextField(User.getVille(), "Ville", 20, TextField.ANY);
        ville.setUIID("TextFieldBlack");
        addStringValue("Ville", ville);

        TextField adresse = new TextField(User.getAdresse(), "Adresse", 20, TextField.ANY);
        adresse.setUIID("TextFieldBlack");
        addStringValue("Adresse", adresse);

        TextField aboutme = new TextField(User.getAboutMe(), "About me", 20, TextField.ANY);
        aboutme.setUIID("TextFieldBlack");
        addStringValue("About me", aboutme);

        TextField password = new TextField(User.getPassword(), "password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("password", password);

        TextField age = new TextField(String.valueOf(User.getAge()), "Age", 20, TextField.NUMERIC);
        age.setUIID("TextFieldBlack");
        addStringValue("Age", age);

        TextField telephone = new TextField(String.valueOf(User.getTelephone()), "Telephone", 20, TextField.NUMERIC);
        telephone.setUIID("TextFieldBlack");
        addStringValue("Telephone", telephone);

             TextField prixHeure = new TextField();
             prixHeure.setUIID("TextFieldBlack");            
             prixHeure.setVisible(false);             
        if (Session.getCurrentSession().getRole().equals("ROLE_COACH")){
             prixHeure.setText(String.valueOf(Session.getCurrentCoachSession().getPrixHeure()));
             addStringValue("PrixHeure", prixHeure);
             prixHeure.setVisible(true);             
        }
        
             TextField poids = new TextField();
             poids.setUIID("TextFieldBlack");             
             poids.setVisible(false);
             //poids.setHidden(true);
             TextField taille = new TextField();
             taille.setUIID("TextFieldBlack");            
          //   taille.setHidden(true);
             taille.setVisible(false);
         if (Session.getCurrentSession().getRole().equals("ROLE_CLIENT")){
         poids.setText(String.valueOf(Session.getCurrentClientSession().getPoids()));
         addStringValue("Poids", poids);
         taille.setText(String.valueOf(Session.getCurrentClientSession().getTaille()));
         addStringValue("Taille", taille);
         poids.setVisible(true);
         taille.setVisible(true);
        }
        
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Toolbar.setGlobalToolbar(true);
                    new Welcome(Session.getCurrentSession(), res).show();

                } catch (Exception ex) {
                    //   Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        save.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent evt) {
                if (email.getText().length() == 0 || nom.getText().length() == 0 || prenom.getText().length() == 0
                        || adresse.getText().length() == 0 || ville.getText().length() == 0 || aboutme.getText().length() == 0
                        || String.valueOf(age.getText()).length() == 0 || String.valueOf(telephone.getText()).length() == 0) {
                    Dialog.show("Alert", "Champs vide", new Command("OK"));
                    return;
                } else {
                    try {
                        Compte c = new Compte(Session.getCurrentSession().getLogin(),
                                nom.getText(), prenom.getText(), Integer.valueOf(age.getText()), telephone.getText(), ville.getText(),
                                adresse.getText(), 0, email.getText(), aboutme.getText());
                               c.setId(Session.getCurrentSession().getId());
//                        if (!Session.getCurrentSession().getPassword().equals(password.getText())) {
//                            c.setPassword(password.getText());
//                        }
                        Toolbar.setGlobalToolbar(false);
                        if (ServiceUser.getInstance().Update(c)) {
                            
                         //SI CLIENT RECUP CLIENT W UPDATE
                      if (Session.getCurrentSession().getRole().equals("ROLE_COACH")){                      
                      CompteCoach cc = new CompteCoach();
                      cc.setPrixHeure(Integer.valueOf(prixHeure.getText()));
                      ServiceUser.getInstance().UpdateCoach(cc);
                      }
                       if (Session.getCurrentSession().getRole().equals("ROLE_CLIENT")){
                      CompteClient cl = new CompteClient();
                      cl.setPoids((Integer.valueOf(poids.getText())));
                      cl.setTaille((Integer.valueOf(taille.getText())));
                      ServiceUser.getInstance().UpdateClient(cl);
                      }
                       System.out.println("REFRESH BELOW ME");
                            ServiceUser.getInstance().refreshUser();
                            new Welcome(Session.getCurrentSession() , res ).show();
                        }
                        
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "!!!", new Command("OK"));
                    }
                }
            }
        });

       

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        // add(createLineSeparator(0xeeeeee));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.entities.Session;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Compte;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.gui.Home;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class Login extends Form {

    Form current;
Media m;
    private static Compte User;

    public Login(Resources res) {
        current = this;
      // Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Login");
        setLayout(new BorderLayout());
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("ContainerWithPadding");

        final TextField username = new TextField();
        username.setHint("Username");
        final TextField pass = new TextField();
        pass.setHint("Password");
        pass.setConstraint(TextField.PASSWORD);

        center.addComponent(username);
        center.addComponent(pass);

        Button signIn = new Button("Sign In");
        signIn.addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent evt) {
                if (username.getText().length() == 0 || pass.getText().length() == 0) {
                    return;
                }
                if ( ServiceUser.getInstance().Login(username.getText(), pass.getText()).getEmail() == null) {
                    Dialog.show("Erreur", "Email et/ou mdp est invalide", new Command("OK"));
                } else {
                  Toolbar.setGlobalToolbar(false);                           
                 Session.start(ServiceUser.getInstance().Login(username.getText(), pass.getText()));
                 ServiceUser.getInstance().setRole();              
                 
                  try {
                m = MediaManager.createMedia((Display.getInstance().getResourceAsStream(getClass(), "/bell.mp3")), "audio/mpeg");
                m.play();
                m.setVolume(5);
                
            } catch (IOException ex) {
                System.out.println("erreur" + ex.getMessage());
            }
               new Home(res).show();   
            //     new Welcome(Session.getCurrentSession() , res ).show(); // PROFIIIIILE

                 Toolbar.setGlobalToolbar(true);
                }
            }  
        }); 

        center.addComponent(signIn);
        Button signUp = new Button("Sign Up");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Toolbar.setGlobalToolbar(false);
                new SignUpForm(res).show();
            }
        }); 
        center.addComponent(signUp);
        addComponent(BorderLayout.CENTER, center);
    }
}

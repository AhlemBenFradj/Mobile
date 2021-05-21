/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.myapp;

import com.mycompany.entities.Compte;
import com.mycompany.entities.User;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends Form {
 Form current;
    public SignUpForm(Resources res) {
         current = this;
        setTitle("inscription");
        setLayout(new BorderLayout());
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("ContainerWithPadding");
        center.setScrollableY(true);

       Form previous = Display.getInstance().getCurrent();
//        tb.setBackCommand("", e -> previous.showBack());
//        setUIID("SignIn");
                
        TextField nom = new TextField("", "nom", 20, TextField.ANY);
        TextField prenom = new TextField("", "prenom", 20, TextField.ANY);
        TextField adresse = new TextField("", "adresse", 20, TextField.ANY);
        TextField age = new TextField("", "age", 20,TextField.NUMERIC);
        TextField telephone = new TextField("", "telephone", 20, TextField.NUMERIC);
        TextField ville = new TextField("", "ville", 20, TextField.ANY);
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField aboutme = new TextField("", "A propos", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        
        

        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        center.addComponent(nom);
        center.addComponent(prenom);
        center.addComponent(age);
        center.addComponent(telephone);
        center.addComponent(ville);
        center.addComponent(adresse);
        center.addComponent(username);
        center.addComponent(email);
        center.addComponent(password);
        center.addComponent(aboutme);
        center.addComponent(confirmPassword);
        Button signUp = new Button("Sign Up");
        
        RadioButton client_button = new RadioButton("client");
        RadioButton coach_button = new RadioButton("entraineur");
        new ButtonGroup(client_button, coach_button);
        client_button.setSelected(true);
        center.add(client_button);
        center.add(coach_button);
        
        
        
        signUp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (email.getText().length() == 0 || password.getText().length() == 0) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                    return;
                } else {
                    try {
                        Toolbar.setGlobalToolbar(false);
                        String roles="ROLE_Client";
                      Compte c = new Compte(username.getText(),password.getText(),nom.getText(),prenom.getText(),Integer.valueOf(age.getText().toString()),telephone.getText(),ville.getText(),
                      adresse.getText(),0,email.getText(),aboutme.getText());
                    
                      if (coach_button.isSelected() ) { roles="ROLE_Coach"; }                     
                      Toolbar.setGlobalToolbar(true);
                      
                        if (ServiceUser.getInstance().addUser(c,roles)) {
                            Dialog.show("Success", "Success", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "ERREUR", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "!!!", new Command("OK"));
                    }
                }
            }
        });

        center.addComponent(signUp);

        add(BorderLayout.SOUTH, BoxLayout.encloseY(
             //   next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
//        next.requestFocus();
//        next.addActionListener(e -> new ActivateForm(res).show());
        addComponent(BorderLayout.CENTER, center);
    }
    
}

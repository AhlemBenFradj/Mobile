/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author hp
 */
public class Contact extends Form{
        
        Form current;
        Resources theme = UIManager.initFirstTheme("/theme");
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public Contact(Resources res){
        
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Contacter l'administration");
        setLayout(BoxLayout.y());

        
TextField Email = new TextField("", "Saisir votre adresse Email", 20, TextArea.EMAILADDR);
TextField body = new TextField("", "Ecrire ici", 2000, TextArea.ANY);
Button upload = new Button("Envoyer");
         upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
    
                if (ServiceProduit.getInstance().SendEmail(Email.getText(),body.getText()))
                            Dialog.show("Success","Votre message a été transmis, nous vous répondrons dans les meilleurs délais.",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));

            }
        });
   Button Retour = new Button("Retour");
        Retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                new HomeProduit(res).show();
            }
        });
        
      
     addAll(Email,body,upload,Retour);
}


}

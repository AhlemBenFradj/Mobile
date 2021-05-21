/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Categorie;
import java.util.ArrayList;
import com.mycompany.myapp.services.ServiceCategorie;

/**
 *
 * @author hp
 */
public class ListCategorie extends Form {
     Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public ListCategorie(Resources res){
        
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Liste Catégories");
        setLayout(BoxLayout.y());

       
        
       


        SpanLabel sp = new SpanLabel();
        ArrayList<Categorie> array=ServiceCategorie.getInstance().getAllTasks();
        for(Categorie C:array)
        {
            
            SpanLabel Description = new SpanLabel();
            System.out.println(C.getDescription());
            Description.setText(C.getDescription());
            
                
            
            
            add("Catégorie:").add(Description);
           
            
        }

        
        
        
            

        Button Retour = new Button("Retour");
        Retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                new HomeProduit(res).show();
            }
        });
        
        

        
        addAll(Retour);
        
    
    }
}

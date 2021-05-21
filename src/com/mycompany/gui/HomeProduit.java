/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author hp
 */
public class HomeProduit extends Form {
    
    Form current;
    
    
    public HomeProduit(Resources res) {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Produits");
        setLayout(BoxLayout.y());

        add(new Label("Bienvenue"));
        Button btnListProduits = new Button("Nos Produits");
        Button btnListCategories = new Button("Nos Catégories");
        Button Contacter = new Button("Contacter nous");
                Button retour = new Button("Retour");  

        btnListProduits.addActionListener(e -> new ListProduit(res).show());
        btnListCategories.addActionListener(e -> new ListCategorie(res).show());
       
        Contacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                new Contact(res).show();
            }
        });
       
          
//         retour.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) { 
//                new Home().show();
//            }
//        });
//       
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new Home(res).show() );
        
        
        
        addAll(btnListProduits,btnListCategories,Contacter);
    
}
    
}

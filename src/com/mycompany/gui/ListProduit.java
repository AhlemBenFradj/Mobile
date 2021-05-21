/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import com.mycompany.entities.Produit;
import com.mycompany.myapp.services.ServiceProduit;
import java.util.List;



/**
 *
 * @author hp
 */
public class ListProduit extends Form {
     
        Form current;
        
    
    public ListProduit(Resources res){
        
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Liste des Produits");
        setLayout(BoxLayout.y());
        
//        TextField recherche = new TextField("", "Saisir ..", 20, TextArea.ANY);
//        Button recherB = new Button("Recherche");
//        
//         recherB.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                ArrayList<Produit> array=ServiceProduit.getInstance().Recherche(recherche.getText());
//        for(Produit p:array)
//        {
//             SpanLabel NomProduit = new SpanLabel();
//             SpanLabel Description = new SpanLabel();
//             SpanLabel Prix = new SpanLabel();
//             SpanLabel Quantite = new SpanLabel();
//             SpanLabel IdcP = new SpanLabel();
//             SpanLabel Reports = new SpanLabel();
//             SpanLabel Images = new SpanLabel();
//        
//            System.out.println(p.getNomProduit());
//            NomProduit.setText(p.getNomProduit());
//            Description.setText(p.getDescription());
//                Image img;
//                try {
//                    img = Image.createImage("file://C:/xamp/htdocs/GestionProduit/public/Imagez/"+p.getImages()).scaledWidth(Math.round(Display.getInstance().getDisplayWidth()));                   
//                    
//                    Images.setIcon(img);
//                } catch (IOException ex) {
//                    
//                }
//           // NomProduit.setText(p.getNomProduit());
//            Prix.setText(String.valueOf(p.getPrix()));
//            Reports.setText(String.valueOf(p.getReports()));
//            Quantite.setText(String.valueOf(p.getQuantite()));
//            
//            
//            add("Nom du produit:").add(NomProduit).
//            add("Description:").add(Description).
//            add("Prix:").add(Prix).
//            add("Quantité:").add(Quantite).
//            add("image:").add(Images);
//            
//            
//        }
//                                        
//            }
//        });
////            addAll(recherche,recherB);

TextField rech = new TextField("","Chercher un produit");
         Button rechercher = new Button("Rechercher");
         rechercher.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent evt) {
                  List <Produit> list =ServiceProduit.getInstance().Recherche(rech.getText());
                   for(Produit p:list)
        {
                 // Produit categ = list.get(0);
              Dialog d = new Dialog("Produit(s)");
              
        TextArea popupBody = new TextArea("Nom: "+p.getNomProduit()+"\n"+" Prix: "+p.getPrix()+"\n"+" Quantité: "+p.getQuantite()+"\n", 7, 10);
        popupBody.setUIID("PopupBody");
        popupBody.setEditable(false);
        d.setLayout(new BorderLayout());
        d.add(BorderLayout.CENTER, popupBody);
        d.showPopupDialog(rechercher);
        
               }}
           });
         addAll(rech,rechercher);
       
        ArrayList<Produit> array=ServiceProduit.getInstance().getAllTasks();
        for(Produit p:array)
        {
             SpanLabel NomProduit = new SpanLabel();
             SpanLabel Description = new SpanLabel();
             SpanLabel Prix = new SpanLabel();
             SpanLabel Quantite = new SpanLabel();
             SpanLabel IdcP = new SpanLabel();
             SpanLabel Reports = new SpanLabel();
             SpanLabel Images = new SpanLabel();
        
            System.out.println(p.getNomProduit());
            NomProduit.setText(p.getNomProduit());
            Description.setText(p.getDescription());
                Image img;
                try {
                    img = Image.createImage("file://C:/Users/iheb/Desktop/PI/Symfony/secondlife/public/Imagez/"+p.getImages()).scaledWidth(Math.round(Display.getInstance().getDisplayWidth()));                   
                    
                    Images.setIcon(img);
                } catch (IOException ex) {
                    
                }
           // NomProduit.setText(p.getNomProduit());
            Prix.setText(String.valueOf(p.getPrix()));
            Reports.setText(String.valueOf(p.getReports()));
            Quantite.setText(String.valueOf(p.getQuantite()));
            String ch = p.getIdcP().toString().substring(13);
            ch = ch.substring(0,ch.length()-1);
            IdcP.setText(ch);
            
            
            add("Nom du produit:").add(NomProduit).
            add("Description:").add(Description).
            add("Prix:").add(Prix).
            add("Quantité:").add(Quantite).
            add("image:").add(Images).
            add("Categorie:").add(IdcP).add("****************************************");
            
        }

 
        
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new HomeProduit(res).show());
        
        
    
    }
    
}

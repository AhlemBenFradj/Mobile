/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Groupe;
import com.mycompany.myapp.services.ServiceGroupe;
import java.util.ArrayList;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class ListeGroupeForm extends Form {

    public ListeGroupeForm(Form previous ,Resources res) {
        setTitle("List Groupe");

        setLayout(BoxLayout.y());
        ArrayList<Groupe> array = ServiceGroupe.getInstance().getAllGroupes();
       
        for (Groupe t : array) {
            SpanLabel titre = new SpanLabel();
            Button like = new Button("Like");
            Button participer = new Button("Participer");
            titre.setText("Type : " + t.getTypeclass());
            add("Titre: " + t.getNomclass() ).add(titre).add(like).add(participer);
            
            like.addActionListener(e -> ServiceGroupe.getInstance().like(20));

           participer.addActionListener(e -> ServiceGroupe.getInstance().participer(20));
        

            add("**********************************************");

        }

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                e -> previous.showBack());

    }

}

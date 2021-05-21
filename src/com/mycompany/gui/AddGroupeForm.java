/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Groupe;
import com.mycompany.myapp.services.ServiceGroupe;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class AddGroupeForm extends Form {

    public AddGroupeForm(Form previous,Resources res) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        setTitle("Add a new task");
        setLayout(BoxLayout.y());

        TextField tfName = new TextField("", "Nom groupe");
        TextField tfType = new TextField("", "Type");
        Button btnValider = new Button("Ajouter");

        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if ((tfName.getText().length() == 0) || (tfType.getText().length() == 0)) {
                        Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                    } else {

                        Groupe t = new Groupe();
                        t.setNomclass(tfName.getText());
                        t.setTypeclass(tfType.getText());
                        ServiceGroupe.getInstance().addGroupe(t);
                        new ListeGroupeForm(previous,res).show();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        addAll(tfName, tfType, btnValider);
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                e -> previous.showBack()); // Revenir vers l'interface précédente

    }

}

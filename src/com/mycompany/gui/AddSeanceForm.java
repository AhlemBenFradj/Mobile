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
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Seance;
import com.mycompany.myapp.services.ServiceSeance;
import com.codename1.ui.util.Resources;
/**
 *
 * @author bhk
 */
public class AddSeanceForm extends Form {

    public AddSeanceForm(Form previous  ,Resources res) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        setTitle("Add a new task");
        setLayout(BoxLayout.y());

        TextField tfName = new TextField("", "Nom Seance");
        TextField tfDesc = new TextField("", "Description");
        Picker tfDate = new Picker();
        TextField tfCoach = new TextField("", "Coach");
        TextField tfRoutine = new TextField("", "Routine");
        TextField tfGroupe = new TextField("", "Groupe");
        Button btnValider = new Button("Ajouter");

        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if ((tfName.getText().length() == 0) || (tfDesc.getText().length() == 0) || (tfDate.getText().length() == 0) || (tfCoach.getText().length() == 0) || (tfRoutine.getText().length() == 0)) {
                        Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                    } else {

                        Seance t = new Seance();
                        t.setTitreseance(tfName.getText());
                        t.setDescseance(tfDesc.getText());
                        t.setDateseance(tfDate.getDate());
                        t.setIdcoach(tfCoach.getText());
                        float idr = Float.parseFloat(tfRoutine.getText().toString());
                        t.setIdroutine((int) idr);
                        t.setLikes(1);
                        t.setGroupe(tfGroupe.getText());
                        ServiceSeance.getInstance().addSeance(t);

                        //  new ListeSeanceForm(previous).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        addAll(tfName, tfDesc, tfDate, tfCoach, tfRoutine, tfGroupe, btnValider);
        this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                e -> previous.showBack()); // Revenir vers l'interface précédente

    }

}

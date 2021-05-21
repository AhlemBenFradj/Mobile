/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.entities.Seance;
import com.mycompany.myapp.services.ServiceSeance;
import java.util.ArrayList;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class ListeSeanceForm extends Form {

    public ListeSeanceForm(Form previous ,Resources res) {
        setTitle("List Seances");

        SpanLabel sp = new SpanLabel();
        ArrayList<Seance> array = ServiceSeance.getInstance().getSeance(20);
        for (Seance t : array) {
            System.out.println(t);
        }
        sp.setText(array.toString());

        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                e -> previous.showBack());

    }

}

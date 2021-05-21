/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.entities.Repas;
import com.mycompany.myapp.services.ServiceRepas;
import java.util.ArrayList;

/**
 *
 * @author ALPHA
 */
public class List_Repas extends Form{

    public List_Repas( Form prev) {
         setTitle("Afficher");
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
         ArrayList<Repas> t=new ServiceRepas().getAllRepas();
   SpanLabel sl=new SpanLabel(t.toString());
   addAll(sl);
    }
    
}

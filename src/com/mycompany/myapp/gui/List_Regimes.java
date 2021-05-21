/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.entities.Regimes;
import com.mycompany.myapp.services.ServiceRegimes;
import java.util.ArrayList;

/**
 *
 * @author ALPHA
 */
public class List_Regimes extends Form{

    public List_Regimes( Form prev) {
         setTitle("Afficher");
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
         ArrayList<Regimes> t=new ServiceRegimes().getAllRegimes();
   SpanLabel sl=new SpanLabel(t.toString());
   addAll(sl);
    }
    
}

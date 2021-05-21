/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Regimes;
import com.mycompany.myapp.services.ServiceRegimes;
import java.util.ArrayList;

/**
 *
 * @author ALPHA
 */
public class List_Regimes extends Form{

    public List_Regimes( Form prev,Resources res) {
         setTitle("Afficher");
         setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
         ArrayList<Regimes> t=new ServiceRegimes().getAllRegimes();
 //  SpanLabel sl=new SpanLabel(t.toString());
   
   
          //  SpanLabel sp = new SpanLabel();
   for (Regimes r : t){
       SpanLabel titre = new SpanLabel();
            titre.setText("Description : "+r.getDescription());
           add("Titre: "+r.getTitre()+ "ImgUml: "+r.getImgUml()).add(titre); 
         //  add("ImgUml: "+r.getImgUml()+" : ").add(titre); 
           add("************************************************");
      
   }
   
   
   
   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new Home(res).show() );
 //  addAll(sl);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Repas;
import com.mycompany.myapp.services.ServiceRepas;
import java.util.ArrayList;
import com.codename1.ui.util.Resources;
/**
 *
 * @author ALPHA
 */
public class List_Repas extends Form{

    public List_Repas( Form prev , Resources res) {
         setTitle("Afficher");
         setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
         ArrayList<Repas> t=new ServiceRepas().getAllRepas();
       //  SpanLabel sl=new SpanLabel(t.toString());
   
         
         
       //  SpanLabel sp = new SpanLabel();
   for (Repas r : t){
       SpanLabel titre = new SpanLabel();
            titre.setText("Description : "+r.getDescription());
           add("Titre: "+r.getTitre()+" \n ImgUml: "+r.getImgUml()).add(titre); 
         //  add("ImgUml: "+r.getImgUml()+" : ").add(titre); 
           add("************************************************");
      
   }
   
   
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new Home(res).show() );
 //  addAll(sl);
    }
    
}

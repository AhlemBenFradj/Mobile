/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Form;

import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
/**
 *
 * @author ALPHA
 */
public class Home extends Form{
Form cur;

    public Home() {
        
            cur=this;
    setTitle("Home");
    setLayout(BoxLayout.y());
    
    add(new Label("choose now"));
    Button btnAjout= new Button("Ajouter Repas");
    Button btnList= new Button("Afficher Repas");
    btnAjout.addActionListener(e-> new Ajouter_Repas(cur).show());
    btnList.addActionListener(e-> new List_Regimes(cur).show());
    addAll(btnAjout,btnList);
    }
  

   
    
}

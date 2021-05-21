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
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Regimes;
import com.mycompany.myapp.services.ServiceRegimes;
/**
 *
 * @author ALPHA
 */
public class Ajouter_Regimes extends Form{

    public Ajouter_Regimes(Form prev,Resources res) {
        setTitle("Ajout");
        TextField tfTitre = new TextField("","Titre");
        TextField tfDesc= new TextField("", "DESC");
        TextField tfImg= new TextField("", "ImgUml");
        Button btnValider = new Button("Add task");
        //MATERIAL_ARROW_BACK
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfTitre.getText().length()==0)||(tfDesc.getText().length()==0)||(tfImg.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Regimes t = new Regimes(tfTitre.getText(), tfDesc.getText(), tfImg.getText());
                        if( ServiceRegimes.getInstance().addRegimes(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new Home(res).show() );
        addAll(tfTitre,tfDesc,tfImg,btnValider);
       
                
    }
    
    }


    
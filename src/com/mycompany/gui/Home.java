/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.charts.util.ColorUtil.GREEN;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Session;
import com.mycompany.myapp.Welcome;

/**
 *
 * @author hp
 */
public class Home extends Form {

    Form current;

    public Home(Resources res) {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Second Life");
        setLayout(BoxLayout.y());

        add(new Label("Bienvenue"));
        Button btnProduits = new Button("Produits");
        Button btnProfile = new Button("Profile");
        //   Button btnListCategories = new Button("Haja okhra..");
        Button listRegimes = new Button("Affiche regimes...");
        Button ajoutRegime = new Button("Ajout regime...");
        Button ajoutRepas = new Button("Ajout repas...");
        Button listRepas = new Button("Liste repas...");

        // btnProduits.addActionListener(e -> new ListProduit(current).show());
        // btnListCategories.addActionListener(e -> new ListCategorie(current).show());
        Button ajoutEvenement = new Button("Ajouter evenement");
        Button afficherEvenement = new Button("Afficher evenements");

        Button AjouterSeance = new Button("Ajout seance...");
        Button ListerSeances = new Button("Liste seance...");
        Button AjouterGroupe = new Button("Ajout groupe...");
        Button ListerGroupes = new Button("Liste groupe...");

        AjouterSeance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddSeanceForm(current, res).show();
            }
        });
        ListerSeances.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ListeSeanceForm(current, res).show();
            }
        });
        AjouterGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddGroupeForm(current, res).show();
            }
        });
        ListerGroupes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ListeGroupeForm(current, res).show();
            }
        });

        ajoutEvenement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddEvent(res).show();
            }
        });

        afficherEvenement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ListEventC(res).show();
            }
        });

        ajoutRepas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Ajouter_Repas(current, res).show();
            }
        });

        listRepas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new List_Repas(current, res).show();
            }
        });

        ajoutRegime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Ajouter_Regimes(current, res).show();
            }
        });

        listRegimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new List_Regimes(current, res).show();
            }
        });

        btnProduits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomeProduit(res).show();
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Welcome(Session.getCurrentSession(), res).show(); // PROFIIIIILE
            }
        });

        addAll(btnProfile, btnProduits, listRegimes, listRepas, afficherEvenement, AjouterSeance, ListerSeances);

        if (Session.getCurrentSession().getRole().equals("ROLE_ADMIN")) {
//ajoutRegime.getAllStyles().setBackgroundGradientEndColor(785);
            add(ajoutEvenement);
            add(ajoutRegime);
            add(ajoutRepas);
            add(AjouterGroupe);
            add(ListerGroupes);
        }
    }

}

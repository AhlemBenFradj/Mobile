/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author Lenovo
 */
public class Session {
    
      private static Compte User=null;
      private static CompteClient compteClient=null;
      private static CompteCoach compteCoach=null;
      private static CompteAdmin compteAdmin=null;
private static String role;


    public static void start(Compte currentUser) {
        User = currentUser;
        System.out.println("STARTED "+currentUser.toString());
    }
       public static void startClient(CompteClient currentUser) {
        compteClient = currentUser;
    }
          public static void startCoach(CompteCoach currentUser) {
        compteCoach = currentUser;
    }
             public static void startAdmin(CompteAdmin currentUser) {
        compteAdmin = currentUser;
    }

    public static Compte getCurrentSession() {
        if (User != null) {
            return User;
        }
        return null;

    }
     public static CompteClient getCurrentClientSession() {
        if (compteClient != null) {
            return compteClient;
        }
        return null;

    }
      public static CompteCoach getCurrentCoachSession() {
        if (compteCoach != null) {
            return compteCoach;
        }
        return null;

    }
       public static CompteAdmin getCurrentAdminSession() {
        if (compteAdmin != null) {
            return compteAdmin;
        }
        return null;

    }
    
        public static void close() throws Exception {
        if (User != null) {
            User =null;
            compteAdmin=null;
            compteCoach=null;
            compteClient=null;
        } else {
            throw new Exception("Session has not started yet!");
        }
    }

        
    
}

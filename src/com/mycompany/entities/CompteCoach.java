package com.mycompany.entities;

public class CompteCoach extends Compte {
	
	private int compteLogin;
	private int prixHeure;
	private boolean valide;
	private int sport ;

	
	

	public CompteCoach() {
	
	}

	
	

	public CompteCoach(int compteLogin,int prixHeure, boolean valide, int sport) {
		super();
		this.compteLogin = compteLogin;
		this.prixHeure = prixHeure;
		this.valide = valide;
		this.sport = sport;
	}




	public CompteCoach(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed, int id ,String email) {
		super(login, password, nom, prenom, age, telephone, ville, adresse, imgUrl, aboutMe, isClosed, id , email);
		// TODO Auto-generated constructor stub
	}




	public CompteCoach(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed , String email,int compteLogin,int prixHeure, boolean valide, int sport) {
		super(login, password, nom, prenom, age, telephone, ville, adresse, imgUrl, aboutMe, isClosed , email);
		this.compteLogin = compteLogin;
		this.prixHeure = prixHeure;
		this.valide = valide;
		this.sport = sport;
	}




	public CompteCoach(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed, int prixHeure2, boolean valide2,
			int sport2) {
		// TODO Auto-generated constructor stub
	}




	public int getPrixHeure() {
		return prixHeure;
	}

	public void setPrixHeure(int prixHeure) {
		this.prixHeure = prixHeure;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public int getSport() {
		return sport;
	}

	public void setSport(int sport) {
		this.sport = sport;
	}



	public int getCompteLogin() {
		return compteLogin;
	}




	public void setCompteLogin(int compteLogin) {
		this.compteLogin = compteLogin;
	}




	@Override
	public String toString() {
		return super.toString()+" CompteCoach [prixHeure=" + prixHeure + ", valide=" + valide + ", sport=" + sport + ", compteLogin="
				+ getLogin() + "]";
	}
	
	

}

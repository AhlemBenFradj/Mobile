package com.mycompany.entities;

public class CompteClient extends Compte {

    private int compteLogin;
	private int poids;
	private int taille;
	private String exceptionMedicale;
	private int coachLogin; 
	
	
	
	public CompteClient() {
		
	}




	public CompteClient(int compteLogin,int poids, int taille, String exceptionMedicale, int coachLogin) {
		super();
		this.compteLogin = compteLogin;
		this.poids = poids;
		this.taille = taille;
		this.exceptionMedicale = exceptionMedicale;
		this.coachLogin = coachLogin;
	}



	public CompteClient(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed, int id ,String email) {
		super(login, password, nom, prenom, age, telephone, ville, adresse, imgUrl, aboutMe, isClosed, id , email);
		// TODO Auto-generated constructor stub
	}



	public CompteClient(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed,String email,int compteLogin,
			int poids, int taille, String exceptionMedicale, int coachLogin) {
		super(login, password, nom, prenom, age, telephone, ville, adresse, imgUrl, aboutMe, isClosed , email);
		this.compteLogin = compteLogin;
		this.poids = poids;
		this.taille = taille;
		this.exceptionMedicale = exceptionMedicale;
		this.coachLogin = coachLogin;
	}



	public int getCompteLogin() {
		return compteLogin;
	}




	public void setCompteLogin(int compteLogin) {
		this.compteLogin = compteLogin;
	}




	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getExceptionMedicale() {
		return exceptionMedicale;
	}
	public void setExceptionMedicale(String exceptionMedicale) {
		this.exceptionMedicale = exceptionMedicale;
	}
	public int getCoachLogin() {
		return coachLogin;
	}
	public void setCoachLogin(int coachLogin) {
		this.coachLogin = coachLogin;
	}
	
	@Override
	public String toString() {
		return super.toString()+" CompteClient [compteLogin=" + getLogin() + ", poids=" + poids + ", taille=" + taille
				+ ", exceptionMedicale=" + exceptionMedicale + ", coachLogin=" + coachLogin + "]";
	}
	
	
}

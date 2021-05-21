package com.mycompany.entities;

public class CompteAdmin extends Compte {
private String DesciprtionTache;
private int compteLogin;

	public CompteAdmin() {

}
    


	public CompteAdmin(String login, String password, String nom, String prenom, int age, String telephone,
			String ville, String adresse, String imgUrl, String aboutMe, int isClosed,int id,String email) {
		super(login, password, nom, prenom, age, telephone, ville, adresse, imgUrl, aboutMe, isClosed , id ,email);
		// TODO Auto-generated constructor stub
	}


	public CompteAdmin(String desciprtionTache,int compteLogin) {
		super();
		this.DesciprtionTache = desciprtionTache;
		this.compteLogin = compteLogin;
	}

	public String getDesciprtionTache() {
		return DesciprtionTache;
	}



	public void setDesciprtionTache(String DesciprtionTache) {
		this.DesciprtionTache = DesciprtionTache;
	}



	public int getCompteLogin() {
		return compteLogin;
	}



	public void setCompteLogin(int compteLogin) {
		this.compteLogin = compteLogin;
	}



	@Override
	public String toString() {
		return super.toString()+" "
				+ "CompteAdmin [DesciprtionTache=" + DesciprtionTache + "]";
	}











	
	
	
}

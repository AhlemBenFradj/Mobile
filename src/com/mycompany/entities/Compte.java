package com.mycompany.entities;

public class Compte {
private String login;
private String password;
private String nom ;
private String prenom ;
private int age ;
private String telephone ;
private String ville ; 
private String adresse ;
private String imgUrl;
private String aboutMe;
private int isClosed;
private int id;
private String role;
private String email;



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }






public Compte() {
	super();
}


public Compte(String login, String nom, String prenom, int age, String telephone, String ville,
		String adresse, int isClosed, String email,String aboutMe) {
	super();
	this.login = login;
	//this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.telephone = telephone;
	this.ville = ville;
	this.adresse = adresse;
	//this.imgUrl = imgUrl;
	this.aboutMe = aboutMe;
	this.isClosed = isClosed;
	//this.id = id;
	this.email = email;
}

public Compte(String login, String password, String nom, String prenom, int age, String telephone, String ville,
		String adresse, int isClosed, String email,String aboutMe) {
	super();
	this.login = login;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.telephone = telephone;
	this.ville = ville;
	this.adresse = adresse;
	//this.imgUrl = imgUrl;
	this.aboutMe = aboutMe;
	this.isClosed = isClosed;
	//this.id = id;
	this.email = email;
}


public Compte(String login, String password, String nom, String prenom, int age, String telephone, String ville,
		String adresse, String imgUrl, String aboutMe, int isClosed, int id,String email) {
	super();
	this.login = login;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.telephone = telephone;
	this.ville = ville;
	this.adresse = adresse;
	this.imgUrl = imgUrl;
	this.aboutMe = aboutMe;
	this.isClosed = isClosed;
	this.id = id;
	this.email = email;
}

public Compte(String login, String password, String nom, String prenom, int age, String telephone, String ville,
		String adresse, String imgUrl, String aboutMe, int isClosed,String email) {
	super();
	this.login = login;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.telephone = telephone;
	this.ville = ville;
	this.adresse = adresse;
	this.imgUrl = imgUrl;
	this.aboutMe = aboutMe;
	this.isClosed = isClosed;
	this.email = email;
}






@Override
public String toString() {
	return "Compte [login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
			+ ", telephone=" + telephone + ", ville=" + ville + ", adresse=" + adresse + ", imgUrl=" + imgUrl
			+ ", aboutMe=" + aboutMe + ", isClosed=" + isClosed + ", id=" + id + "email"+ email +"ROLE= "+role+"]";
}







public String getLogin() {
	return login;
}







public void setLogin(String login) {
	this.login = login;
}







public String getEmail() {
	return email;
}







public void setEmail(String email) {
	this.email = email;
}







public String getPassword() {
	return password;
}







public void setPassword(String password) {
	this.password = password;
}







public String getNom() {
	return nom;
}







public void setNom(String nom) {
	this.nom = nom;
}







public String getPrenom() {
	return prenom;
}







public void setPrenom(String prenom) {
	this.prenom = prenom;
}







public int getAge() {
	return age;
}







public void setAge(int age) {
	this.age = age;
}







public String getTelephone() {
	return telephone;
}







public void setTelephone(String telephone) {
	this.telephone = telephone;
}







public String getVille() {
	return ville;
}







public void setVille(String ville) {
	this.ville = ville;
}







public String getAdresse() {
	return adresse;
}







public void setAdresse(String adresse) {
	this.adresse = adresse;
}







public String getImgUrl() {
	return imgUrl;
}







public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}







public String getAboutMe() {
	return aboutMe;
}







public void setAboutMe(String aboutMe) {
	this.aboutMe = aboutMe;
}







public int getIsClosed() {
	return isClosed;
}







public void setIsClosed(int isClosed) {
	this.isClosed = isClosed;
}







public int getId() {
	return id;
}







public void setId(int id) {
	this.id = id;
}









}

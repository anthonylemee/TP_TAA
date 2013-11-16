package fr.istic.taa.yeoman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * Class qui défini le modèle de l'entité Utilisateur
 * sous-type de Personne
 */
@Entity 
public class Utilisateur extends APersonne
{
	 
	@Column(nullable = false) 
	protected String pseudo;
	 
	@Column(nullable = false) 
	protected String facebook;
	
	@Column(nullable = false) 
	protected String twitter;

	@Column(nullable = false) 
	protected String mail;

	@Column(nullable = false) 
	protected String avatar;

	/**
	 * Constrcuteur de la classe Utilisateur
	 */
	public Utilisateur(){
		super();
	}

	public String getPseudo() {
		return this.pseudo;	
	}
	
	public String getFacebook() {
		return this.facebook;	
	}
	
	public String getTwitter() {
		return this.twitter;	
	}
	
	public String getMail() {
		return this.mail;	
	}
	
	public String getAvatar() {
		return this.avatar;	
	}
	
	public void setPseudo(String myPseudo) {
		this.pseudo = myPseudo;	
	}
	
	public void setFacebook(String myFacebook) {
		this.facebook = myFacebook;	
	}
	
	public void setTwitter(String myTwitter) {
		this.twitter = myTwitter;	
	}
	
	public void setMail(String myMail) {
		this.mail = myMail;	
	}
	
	public void setAvatar(String myAvatar) {
		this.avatar = myAvatar;	
	}
	
	public void unsetPseudo() {
		this.pseudo = "";	
	}
	
	public void unsetFacebook() {
		this.facebook = "";	
	}

	public void unsetTwitter() {
		this.twitter = "";	
	}
	
	public void unsetMail() {
		this.mail = "";	
	}

	public void unsetAvatar() {
		this.avatar = "";	
	}
	
} // class


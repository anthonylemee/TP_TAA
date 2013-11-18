package fr.istic.taa.yeoman.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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
	
	@OneToMany(mappedBy = "utilisateur") 
	protected Set<Seance> seance;
	

	/**
	 * Constructeur de la classe Utilisateur
	 */
	public Utilisateur(){
		super();
	}
	
	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		for (Seance tmp : newSeance)
			tmp.setUtilisateur(this);
			
	}
	
	public void removeAllSeance(Set<Seance> newSeance) {
		if(this.seance == null) {
			return;
		}
		
		this.seance.removeAll(newSeance);	
	}
	
	public void addSeance(Seance newSeance) {
		if(this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		
		if (this.seance.add(newSeance))
			newSeance.basicSetUtilisateur(this);;	
	}
	
	public void removeSeance(Seance oldSeance) {
		
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.unsetUtilisateur();
			
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
	
	public long getId() {
		return this.id;	
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
	
	public String log() { return ""; }
	
} // class


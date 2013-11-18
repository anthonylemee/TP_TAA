package fr.istic.taa.yeoman.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;


/**
 * Entité Abstraite Personne
 */
@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class APersonne
{

	@Column(nullable = false) 
	protected String name;

	@Column(nullable = false) 
	protected String first_name;
	 
	@Temporal(javax.persistence.TemporalType.DATE) 
	@Column(nullable = false) 
	protected Date birthDate;

	@Column(nullable = false) 
	protected int weight;
	 
	@Column(nullable = false) 
	protected int height;
	 
	@Column(nullable = false) 
	protected boolean sex;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * Constructeur de la classe APersonne
	 */
	public APersonne(){
		super();
	}
	
	public void setName(String myName) {
		this.name = myName;	
	}
	
	public void setFirst_name(String myFirst_name) {
		this.first_name = myFirst_name;	
	}
	
	public void setBirthDate(Date myBirthDate) {
		this.birthDate = myBirthDate;	
	}
	
	public void setWeight(int myWeight) {
		this.weight = myWeight;	
	}
	
	public void setHeight(int myHeight) {
		this.height = myHeight;	
	}
	
	public void setSex(boolean mySex) {
		this.sex = mySex;	
	}
	
	public String getName() {
		return this.name;	
	}

	public String getFirst_name() {
		return this.first_name;	
	}

	public Date getBirthDate() {
		return this.birthDate;	
	}
	
	public int getWeight() {
		return this.weight;	
	}
	
	public int getHeight() {
		return this.height;	
	}
	
	public boolean isSex() {
		return this.sex;	
	}
	
	public long getId() {
		return this.id;	
	}
	
	public void unsetName() {
		this.name = "";	
	}
	
	public void unsetFirst_name() {
		this.first_name = "";	
	}
	
	public void unsetBirthDate() {
		this.birthDate = new Date();	
	}
	
	public void unsetWeight() {
		this.weight = 0;	
	}
	
	public void unsetHeight() {
		this.height = 0;	
	}
	
	public void unsetSex() {
		this.sex = false;	
	}
	
	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	public String log() {
		
		return  " [ID] " + this.id +
				" [BirthDate] " + this.birthDate.toString() +
				" [sex] " + (this.sex ? "homme":"femme") +
				" [Height] " + this.height +
				" [Weight] " + this.weight +
				" [Name] " + this.name + 
				" [FName] " + this.first_name;
		
	}
} // class


package fr.istic.taa.yeoman.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "personne") 
	protected Set<Seance> seance;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * Constructeur de la classe APersonne
	 */
	public APersonne(){
		super();
	}
	
	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		for (Seance tmp : newSeance)
			tmp.setAPersonne(this);
			
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
			newSeance.basicSetAPersonne(this);	
	}
	
	public void removeSeance(Seance oldSeance) {
		
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.unsetAPersonne();
			
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
	
	public Set<Seance> getSeance() {
		if(this.seance == null) {
				this.seance = new HashSet<Seance>();
		}
		return (Set<Seance>) this.seance;	
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
	
} // class


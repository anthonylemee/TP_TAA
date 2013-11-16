package fr.istic.taa.yeoman.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class qui défini le modèle de l'entité Sport
 */
@Entity 
public class Sport
{

	@Id 
	@Column(nullable = false) 
	protected Long id;

	@Column(nullable = false) 
	protected String nom_sport;

	@Column(nullable = false) 
	protected String type_sport;

	@OneToMany 
	protected Set<Seance> seance;

	/**
	 * Constructeur de la classe Sport
	 */
	public Sport(){
		super();
	}

	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		for (Seance tmp : newSeance)
			tmp.setSport(this);
			
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
			newSeance.basicSetSport(this);	
	}
	
	public void removeSeance(Seance oldSeance) {
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.unsetSport();
			
	}
	
	public long getId() {
		return this.id;	
	}
	
	public String getNom_sport() {
		return this.nom_sport;	
	}

	public String getType_sport() {
		return this.type_sport;	
	}

	public Set<Seance> getSeance() {
		if(this.seance == null) {
				this.seance = new HashSet<Seance>();
		}
		return (Set<Seance>) this.seance;	
	}
	
	public void setId(long myId) {
		this.id = myId;	
	}

	public void setNom_sport(String myNom_sport) {
		this.nom_sport = myNom_sport;	
	}
	
	public void setType_sport(String myType_sport) {
		this.type_sport = myType_sport;	
	}
	
	public void unsetId() {
		this.id = 0L;	
	}
	
	public void unsetNom_sport() {
		this.nom_sport = "";	
	}
	
	public void unsetType_sport() {
		this.type_sport = "";	
	}
	
}


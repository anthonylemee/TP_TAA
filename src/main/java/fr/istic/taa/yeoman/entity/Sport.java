package fr.istic.taa.yeoman.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import fr.istic.taa.yeoman.entity.interfaces.ISport;

/**
 * Class qui défini le modèle de l'entité Sport
 */
@Entity 
@Table(name="sport")
public class Sport implements ISport
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false) 
	protected Long id;

	@Column(nullable = false) 
	protected String nom_sport;

	@Column(nullable = false) 
	protected String type_sport;

	@OneToMany (fetch=FetchType.EAGER)
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
	
	@Override
	public long getId() {
		return this.id;	
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonManagedReference
	public String getNom_sport() {
		return this.nom_sport;	
	}

	@JsonManagedReference
	public String getType_sport() {
		return this.type_sport;	
	}

	@JsonBackReference
	public Set<Seance> getSeance() {
		if(this.seance == null) {
				this.seance = new HashSet<Seance>();
		}
		return (Set<Seance>) this.seance;	
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
	
	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	@Override
	public String log() { 
		
		return " [ID] " + this.id +
				" [NOM] " + this.nom_sport +
				" [TYPE] " + this.type_sport +
				" [SEANCES] " + this.logSeance(); 
	} // method
	
	/**
	 * Méthode qui permet d'afficher sous forme de 
	 * log les seances associées à ce sport 
	 * @return String
	 */
	private String logSeance() {
		
		String seances = " / ";
		
		for (Seance seance : this.seance) {
			seances += seance.id + " / ";
		}
		
		return seances;
		
	} // method
	
} // class

 
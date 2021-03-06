package fr.istic.taa.yeoman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import fr.istic.taa.yeoman.entity.interfaces.IMeteo;

/**
 * 	Class qui défini le modèle de l'entité Météo 
 */
@Entity 
@Table(name="meteo")
public class Meteo implements IMeteo
{

	@Column(nullable = false) 
	protected String weather;

	@Column(nullable = false) 
	protected Integer humidity;
	 
	@OneToOne(mappedBy = "meteo") 
	protected Seance seance;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false) 
	protected Long id;

	/**
	 * Constructeur de la classe
	 */
	public Meteo(){
		super();
	}

	public void basicSetSeance(Seance mySeance) {
		if (this.seance != mySeance) {
			if (mySeance != null){
				if (this.seance != mySeance) {
					Seance oldseance = this.seance;
					this.seance = mySeance;
					if (oldseance != null)
						oldseance.unsetMeteo();
				}
			}
		}	
	}

	public String getWeather() {
		return this.weather;	
	}

	public Integer getHumidity() {
		return this.humidity;	
	}

	@JsonBackReference
	public Seance getSeance() {
		return this.seance;	
	}

	@Override
	public long getId() {
		return this.id;	
	}
	
	@Override
	public void setId(Long ids) {
		this.id = ids;	
	}

	public void setWeather(String myWeather) {
		this.weather = myWeather;	
	}

	public void setHumidity(Integer myHumidity) {
		this.humidity = myHumidity;	
	}

	public void setSeance(Seance mySeance) {
		this.basicSetSeance(mySeance);
		mySeance.basicSetMeteo(this);
			
	}
	
	public void unsetWeather() {
		this.weather = "";	
	}
	
	public void unsetHumidity() {
		this.humidity = null;	
	}
	
	public void unsetSeance() {
		if (this.seance == null)
			return;
		Seance oldseance = this.seance;
		this.seance = null;
		oldseance.unsetMeteo();	
	}
	
	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	@Override
	public String log(){
		
		return  " [ID] " + this.id +
				" [weather] " + this.weather +
				" [Humidity] " + this.humidity + 
				" [Seance] " + (this.seance == null ? "null" : this.seance.id);
	}
	
}


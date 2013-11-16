package fr.istic.taa.yeoman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 	Class qui défini le modèle de l'entité Météo 
 */
@Entity 
public class Meteo
{

	@Column(nullable = false) 
	protected String weather;

	@Column(nullable = false) 
	protected Integer humidity;
	 
	@OneToOne(mappedBy = "meteo") 
	protected Seance seance;

	@Id 
	@Column(nullable = false) 
	protected final Long id = 0L;

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

	public Seance getSeance() {
		return this.seance;	
	}

	public long getId() {
		return this.id;	
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
	
}


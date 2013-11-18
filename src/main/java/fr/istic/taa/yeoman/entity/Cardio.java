package fr.istic.taa.yeoman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 	Class qui défini le modèle de l'entité Cardio 
 */
@Entity 
public class Cardio
{

	@Column(nullable = false) 
	protected double frequency;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	protected Seance seance;

	@Id 
	@Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * Constructeur de la classe Cardio
	 */
	public Cardio(){
		super();
	}

	public void basicSetSeance(Seance mySeance) {
		if (this.seance != mySeance) {
			if (mySeance != null){
				if (this.seance != mySeance) {
					Seance oldseance = this.seance;
					this.seance = mySeance;
					if (oldseance != null)
						oldseance.removeCardio(this);
				}
			}
		}	
	}
	
	public void setFrequency(double myFrequency) {
		this.frequency = myFrequency;	
	}
	
	public void setSeance(Seance mySeance) {
		this.basicSetSeance(mySeance);
		mySeance.addCardio(this);	
	}

	public double getFrequency() {
		return this.frequency;	
	}

	public Seance getSeance() {
		return this.seance;	
	}

	public long getId() {
		return this.id;	
	}
	
	public void unsetFrequency() {
		this.frequency = 0.0;	
	}
	
	public void unsetSeance() {
		if (this.seance == null)
			return;
		Seance oldseance = this.seance;
		this.seance = null;
		oldseance.removeCardio(this);	
	}

	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	public String log() {			
		return  " [ID] " + this.id +
				" [frequence] " + this.frequency +
				" [Seance] " + this.seance.log();
	}
}


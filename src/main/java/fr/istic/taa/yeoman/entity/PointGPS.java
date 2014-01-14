package fr.istic.taa.yeoman.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import fr.istic.taa.yeoman.entity.interfaces.IPointGPS;


/**
 * Class qui défini le modèle de l'entité PointGPS
 */ 
@Entity 
@Table(name="point_gps")
public class PointGPS implements IPointGPS
{

	@Column(nullable = false) 
	protected float latitude;

	@Column(nullable = false) 
	protected float longitude;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false)
	protected Parcours parcours;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false) 
	protected Long id;

	/**
	 * Constructeur de la classe PointGPS
	 */
	public PointGPS(){
		super();
	}

	@JsonManagedReference
	public float getLatitude() {
		return this.latitude;	
	}
	
	@JsonManagedReference
	public float getLongitude() {
		return this.longitude;	
	}

	@JsonBackReference
	public Parcours getParcours() {
		return this.parcours;	
	}

	@Override
	public long getId() {
		return this.id;	
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public void basicSetParcours(Parcours myParcours) {
		if (this.parcours != myParcours) {
			if (myParcours != null){
				if (this.parcours != myParcours) {
					Parcours oldparcours = this.parcours;
					this.parcours = myParcours;
					if (oldparcours != null)
						oldparcours.removePointGPS(this);
				}
			}
		}	
	}

	public void setLatitude(float myLatitude) {
		this.latitude = myLatitude;	
	}
	
	public void setLongitude(float y) {
		this.longitude = y;	
	}

	public void setParcours(Parcours myParcours) {
		this.basicSetParcours(myParcours);
		myParcours.addPointGPS(this);	
	}
	
	public void unsetParcours() {
		if (this.parcours == null)
			return;
		Parcours oldparcours = this.parcours;
		this.parcours = null;
		oldparcours.removePointGPS(this);	
	}

	public void unsetXPoint() {
		this.latitude = 0;	
	}
	
	public void unsetYPoint() {
		this.longitude = 0;	
	}
	
	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	@Override
	public String log() { 
		
		return " [ID] " + this.id +
				" [lat] " + this.latitude +
				" [lon] " + this.longitude +
				" [PARCOURS] " + this.parcours.id; 
	} // method

} // class


package fr.istic.taa.yeoman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Class qui défini le modèle de l'entité PointGPS
 */ 
@Entity 
public class PointGPS
{

	@Column(nullable = false) 
	protected int xPoint;

	@Column(nullable = false) 
	protected int yPoint;

	@Column(nullable = false) 
	protected int zPoint;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	protected Parcours parcours;

	@Id 
	@Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * Constructeur de la classe PointGPS
	 */
	public PointGPS(){
		super();
	}

	public int getXPoint() {
		return this.xPoint;	
	}
	
	public int getYPoint() {
		return this.yPoint;	
	}

	public int getZPoint() {
		return this.zPoint;	
	}

	public Parcours getParcours() {
		return this.parcours;	
	}

	public long getId() {
		return this.id;	
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

	public void setXPoint(int myXPoint) {
		this.xPoint = myXPoint;	
	}
	
	public void setYPoint(int myYPoint) {
		this.yPoint = myYPoint;	
	}
	
	public void setZPoint(int myZPoint) {
		this.zPoint = myZPoint;	
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
		this.xPoint = 0;	
	}
	
	public void unsetYPoint() {
		this.yPoint = 0;	
	}
	
	public void unsetZPoint() {
		this.zPoint = 0;	
	}
	
	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	public String log() { 
		
		return " [ID] " + this.id +
				" [X] " + this.xPoint +
				" [Y] " + this.yPoint +
				" [Z] " + this.zPoint +
				" [PARCOURS] " + this.parcours.id; 
	} // method

} // class


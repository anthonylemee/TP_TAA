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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import fr.istic.taa.yeoman.entity.interfaces.IParcours;

/**
 * Class qui défini le modèle de l'entité Séance
 */
@Entity
@Table(name = "parcours")
public class Parcours implements IParcours {

	@Column(nullable = false)
	protected Integer nbKilom;

	@Column(nullable = false)
	protected Integer speed;

	@OneToMany(mappedBy = "parcours", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	protected Set<PointGPS> pointsGPS;

	@OneToOne(mappedBy = "parcours",cascade=CascadeType.ALL)
	protected Seance seance;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	protected Long id;

	/**
	 * Constructeur de la classe Parcours
	 */
	public Parcours() {
		super();
	}

	public void addPointGPS(PointGPS newPointGPS) {
		if (this.pointsGPS == null) {
			this.pointsGPS = new HashSet<PointGPS>();
		}

		if (this.pointsGPS.add(newPointGPS))
			newPointGPS.basicSetParcours(this);
	}

	public void addAllPointGPS(Set<PointGPS> newPointGPS) {
		if (this.pointsGPS == null) {
			this.pointsGPS = new HashSet<PointGPS>();
		}
		if (pointsGPS.size() != 0) {
			for (PointGPS tmp : newPointGPS)
				tmp.setParcours(this);
		}
	}

	public void removeAllPointGPS(Set<PointGPS> newPointGPS) {
		if (this.pointsGPS == null) {
			return;
		}
		this.pointsGPS.removeAll(newPointGPS);
	}

	public void removePointGPS(PointGPS oldPointGPS) {
		if (this.pointsGPS == null)
			return;
		if (this.pointsGPS.remove(oldPointGPS))
			oldPointGPS.unsetParcours();
	}

	@JsonManagedReference
	public Integer getNbKilom() {
		return this.nbKilom;
	}

	@JsonManagedReference
	public Integer getSpeed() {
		return this.speed;
	}

	@JsonManagedReference
	public Set<PointGPS> getPointGPS() {
		if (this.pointsGPS == null) {
			this.pointsGPS = new HashSet<PointGPS>();
		}
		return (Set<PointGPS>) this.pointsGPS;
	}

	@JsonBackReference
	public Seance getSeance() {
		return this.seance;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public void setNbKilom(Integer myNbKilom) {
		this.nbKilom = myNbKilom;
	}

	public void setSpeed(Integer mySpeed) {
		this.speed = mySpeed;
	}

	public void setSeance(Seance mySeance) {
		this.basicSetSeance(mySeance);
		mySeance.basicSetParcours(this);

	}

	public void basicSetSeance(Seance mySeance) {
		if (this.seance != mySeance) {
			if (mySeance != null) {
				if (this.seance != mySeance) {
					Seance oldseance = this.seance;
					this.seance = mySeance;
					if (oldseance != null)
						oldseance.unsetParcours();
				}
			}
		}
	}

	public void unsetNbKilom() {
		this.nbKilom = null;
	}

	public void unsetSpeed() {
		this.speed = null;
	}

	public void unsetSeance() {
		if (this.seance == null)
			return;
		Seance oldseance = this.seance;
		this.seance = null;
		oldseance.unsetParcours();
	}

	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * 
	 * @return String
	 */
	@Override
	public String log() {

		return " [ID] " + this.id + " [nbKm] " + this.nbKilom + " [km/h] "
				+ this.speed + " [Seance] "
				+ (this.seance == null ? "null" : this.seance.id);
	}
} // class


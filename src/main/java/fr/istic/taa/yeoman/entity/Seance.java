package fr.istic.taa.yeoman.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.istic.taa.yeoman.entity.interfaces.ISeance;

/**
 * 	Class qui défini le modèle de l'entité Séance 
 */
@Entity 
@Table(name="seance")
public class Seance implements ISeance
{

	@Temporal(TemporalType.DATE) 
	@Column(nullable = false) 
	protected Date date;

	@Temporal(TemporalType.DATE) 
	@Column(nullable = false) 
	protected Date endDate;

	@Temporal(TemporalType.DATE) 
	@Column(nullable = false) 
	protected Date beginDate;

	@Column(nullable = false) 
	protected int time;

	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(nullable = false) 
	protected Sport sport;

	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(nullable = false) 
	protected Utilisateur utilisateur;
	
	@OneToOne(fetch=FetchType.EAGER)
	protected Parcours parcours;

	@OneToOne (fetch=FetchType.EAGER)
	protected Meteo meteo;

	@OneToMany (fetch=FetchType.EAGER)
	protected Set<Cardio> cardio;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(nullable = false) 
	protected Long id;

	/**
	 * Constructeur de la classe Seance
	 */
	public Seance() {
		super();
	}
	
	public void addAllCardio(Set<Cardio> newCardio) {
			
			if (this.cardio == null) {
				this.cardio = new HashSet<Cardio>();
			}
			for (Cardio tmp : newCardio)
				tmp.setSeance(this);
				
		}
	
	public void addCardio(Cardio newCardio) {
		
		if (this.cardio == null) {
			this.cardio = new HashSet<Cardio>();
		}
		
		if (this.cardio.add(newCardio))
			newCardio.basicSetSeance(this);
			
	}

	public void removeAllCardio(Set<Cardio> newCardio) {
		if(this.cardio == null) {
			return;
		}
		
		this.cardio.removeAll(newCardio);	
	}
	
	public void removeCardio(Cardio oldCardio) {
		if(this.cardio == null)
			return;
		
		if (this.cardio.remove(oldCardio))
			oldCardio.unsetSeance();
			
	}

	public Date getDate() {
		return this.date;	
	}

	public Date getEndDate() {
		return this.endDate;	
	}
	
	public Date getBeginDate() {
		return this.beginDate;	
	}

	public int getTime() {
		return this.time;	
	}

	public Sport getSport() {
		return this.sport;	
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;	
	}

	public Parcours getParcours() {
		return this.parcours;	
	}
	
	public Meteo getMeteo() {
		return this.meteo;	
	}

	public Set<Cardio> getCardio() {
		if(this.cardio == null) {
				this.cardio = new HashSet<Cardio>();
		}
		return (Set<Cardio>) this.cardio;	
	}
	
	@Override
	public long getId() {
		return this.id;	
	}
	
	public void setDate(Date myDate) {
		this.date = myDate;	
	}
	
	public void setEndDate(Date myEndDate) {
		this.endDate = myEndDate;	
	}
	
	public void setBeginDate(Date myBeginDate) {
		this.beginDate = myBeginDate;	
	}
	
	public void setTime(int myTime) {
		this.time = myTime;	
	}
	
	public void setSport(Sport mySport) {
		this.basicSetSport(mySport);
		mySport.addSeance(this);	
	}
	
	public void setUtilisateur(Utilisateur myUtilisateur) {
		this.basicSetUtilisateur(myUtilisateur);
		myUtilisateur.addSeance(this);	
	}
	
	public void setParcours(Parcours myParcours) {
		this.basicSetParcours(myParcours);
		myParcours.basicSetSeance(this);	
	}
	
	public void setMeteo(Meteo myMeteo) {
		this.basicSetMeteo(myMeteo);
		myMeteo.basicSetSeance(this);
			
	}
	
	public void basicSetSport(Sport mySport) {
		if (this.sport != mySport) {
			if (mySport != null){
				if (this.sport != mySport) {
					Sport oldsport = this.sport;
					this.sport = mySport;
					if (oldsport != null)
						oldsport.removeSeance(this);
				}
			}
		}	
	}
	
	public void basicSetUtilisateur(Utilisateur myUtilisateur) {
		if (this.utilisateur != myUtilisateur) {
			if (myUtilisateur != null){
				if (this.utilisateur != myUtilisateur) {
					Utilisateur oldutilisateur = this.utilisateur;
					this.utilisateur = myUtilisateur;
					if (oldutilisateur != null)
						oldutilisateur.removeSeance(this);
				}
			}
		}	
	}
	
	public void basicSetParcours(Parcours myParcours) {
		if (this.parcours != myParcours) {
			if (myParcours != null){
				if (this.parcours != myParcours) {
					Parcours oldparcours = this.parcours;
					this.parcours = myParcours;
					if (oldparcours != null)
						oldparcours.unsetSeance();
				}
			}
		}	
	}
	
	public void basicSetMeteo(Meteo myMeteo) {
		if (this.meteo != myMeteo) {
			if (myMeteo != null){
				if (this.meteo != myMeteo) {
					Meteo oldmeteo = this.meteo;
					this.meteo = myMeteo;
					if (oldmeteo != null)
						oldmeteo.unsetSeance();
				}
			}
		}	
	}
	
	public void unsetDate() {
		this.date = new Date();	
	}
	
	public void unsetEndDate() {
		this.endDate = new Date();	
	}
	
	public void unsetBeginDate() {
		this.beginDate = new Date();	
	}
	
	public void unsetTime() {
		this.time = 0;	
	}
	
	public void unsetSport() {
		if (this.sport == null)
			return;
		Sport oldsport = this.sport;
		this.sport = null;
		oldsport.removeSeance(this);	
	}
	
	public void unsetUtilisateur() {
		if (this.utilisateur == null)
			return;
		Utilisateur oldutilisateur = this.utilisateur;
		this.utilisateur = null;
		oldutilisateur.removeSeance(this);	
	}
	
	public void unsetParcours() {
		if (this.parcours == null)
			return;
		Parcours oldparcours = this.parcours;
		this.parcours = null;
		oldparcours.unsetSeance();	
	}
	
	public void unsetMeteo() {
		if (this.meteo == null)
			return;
		Meteo oldmeteo = this.meteo;
		this.meteo = null;
		oldmeteo.unsetSeance();	
	}

	/**
	 * Méthode servant à afficher l'objet courant dans les logs
	 * @return String
	 */
	@Override
	public String log() {
		
		return  " [ID] " + this.id +
				" [Date] " + this.date.toString() +
				" [DateDeb] " + this.beginDate.toString() +
				" [DateEnd] " + this.endDate.toString() +
				" [Time] " + this.time +
				" [IDSport] " + this.sport.id +
				" [IDUser] " + this.utilisateur.id +
				" [IDParcours] " + this.parcours.id + 
				" [IDMeteo] " + this.meteo.id +
				" [FreqCardio] " + this.logCardio();
		
	}

	/**
	 * Méthode qui permet d'afficher sous forme de 
	 * log les fréquences cardiaques lors de la séance. 
	 * @return String
	 */
	private String logCardio() {
		
		String frequences = " / ";
		
		for (Cardio cardio : this.cardio) {
			frequences += cardio.frequency + " / ";
		}
		
		return frequences;
		
	} // method
	
} // class

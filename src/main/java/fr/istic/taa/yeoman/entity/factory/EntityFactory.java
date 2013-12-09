package fr.istic.taa.yeoman.entity.factory;

import java.util.Date;
import java.util.Set;

import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.Sport;
import fr.istic.taa.yeoman.entity.Utilisateur;

/**
 * Factory pour la création des Entités
 * @author Dano Jimmy et LE MEE Anthony
 */
public class EntityFactory implements IEntityFactory {

	@Override
	public Cardio createCardio(double frequency, Seance seance) {
		Cardio cardio = new Cardio();
		cardio.setFrequency(frequency);
		cardio.basicSetSeance(seance);
		return cardio;
	}

	@Override
	public Meteo createMeteo(String weather, Integer humidity, Seance seance) {
		Meteo meteo = new Meteo();
		meteo.setWeather(weather);
		meteo.setHumidity(humidity);
		meteo.basicSetSeance(seance);
		return meteo;
	}

	@Override
	public Parcours createParcours(int nbKilom, int speed,
			Set<PointGPS> pointsGPS, Seance seance) {
		Parcours parcours = new Parcours();
		parcours.setNbKilom(nbKilom);
		parcours.setSpeed(speed);
		parcours.addAllPointGPS(pointsGPS);
		parcours.basicSetSeance(seance);
		return parcours;
	}

	@Override
	public PointGPS createPointGPS(int x, int y, int z, Parcours parcours) {
		PointGPS p = new PointGPS();
		p.setXPoint(x);
		p.setYPoint(y);
		p.setZPoint(z);
		p.basicSetParcours(parcours);
		return p;
	}

	@Override
	public Seance createSeance(Date date, Date beginDate, Date endDate,
			int time, Meteo meteo, Parcours parcours, Sport sport, Utilisateur utilisateur, Set<Cardio> cardios) {
		Seance seance = new Seance();
		seance.setBeginDate(beginDate);
		seance.setTimeFin(endDate);
		seance.setTime(time);
		seance.basicSetMeteo(meteo);
		seance.basicSetParcours(parcours);
		seance.basicSetSport(sport);
		seance.basicSetUtilisateur(utilisateur);
		seance.addAllCardio(cardios);
		return seance;
	}

	@Override
	public Sport createSport(String nom, String type, Seance seance) {
		Sport sport = new Sport();
		sport.setNom_sport(nom);
		sport.setType_sport(type);
		sport.addSeance(seance);
		return sport;
	}
	
	@Override
	public Utilisateur createUtilisateur(String firstName, String avatar, Date birthDate, String facebook, 
			int height, String mail, String name, String pseudo, Character sexe, 
			String twitter, int weight, Seance seance) {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setFirst_name(firstName);
		utilisateur.setAvatar(avatar);
		utilisateur.setBirthDate(birthDate);
		utilisateur.setFacebook(facebook);
		utilisateur.setHeight(height);
		utilisateur.setMail(mail);
		utilisateur.setName(name);
		utilisateur.setPseudo(pseudo);
		utilisateur.setSex(sexe);
		utilisateur.setTwitter(twitter);
		utilisateur.setWeight(weight);
		utilisateur.addSeance(seance);
		return utilisateur;
		
	}
	
} // class

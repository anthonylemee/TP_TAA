package fr.istic.taa.yeoman.entity.factory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.Sport;
import fr.istic.taa.yeoman.entity.Utilisateur;

public interface IEntityFactory {
	
	public Cardio createCardio(double frequency, Seance seance);
	public Meteo createMeteo(String weather, Integer humidity, Seance seance);
	public Parcours createParcours(int nbKilom, int speed, Set<PointGPS> pointsGPS, Seance seance);
	public PointGPS createPointGPS(int x, int y, int z, Parcours parcours);
	public Seance createSeance(Timestamp beginDate, Timestamp endDate, 
			Meteo meteo, Parcours parcours, Sport sport, Utilisateur utilisateur, Set<Cardio> cardios);
	public Sport createSport(String nom, String type, Seance seance);
	public Utilisateur createUtilisateur(String firstName, String avatar, Date birthDate,
			String facebook, int height, String mail, String name,
			String pseudo, Character sexe, String twitter, int weight, Seance seance);

	
}

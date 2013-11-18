package fr.istic.taa.yeoman.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.istic.taa.yeoman.dao.DAOCardio;
import fr.istic.taa.yeoman.dao.DAOMeteo;
import fr.istic.taa.yeoman.dao.DAOParcours;
import fr.istic.taa.yeoman.dao.DaoPointGPS;
import fr.istic.taa.yeoman.dao.DaoSeance;
import fr.istic.taa.yeoman.dao.DaoSport;
import fr.istic.taa.yeoman.dao.DaoUtilisateur;
import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.Sport;
import fr.istic.taa.yeoman.entity.Utilisateur;
import fr.istic.taa.yeoman.entity.factory.EntityFactory;

/**
 * Classe Main : Client
 * @author Jimmy DANO & Anthony LE MEE
 *
 */
public class Main {

	/**
	 * Constructeur de la classe
	 */
	public Main() {}
	
	/**
	 * Méthode main
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpa" );
		EntityManager em = emf.createEntityManager();
		
		/** Instanciation des Dao */
		DaoSeance dSeance = new DaoSeance(em);
		DAOMeteo dMeteo = new DAOMeteo(em);
		DAOCardio dCardio = new DAOCardio(em);
		DAOParcours dParcours = new DAOParcours(em);
		DaoPointGPS dPointgps = new DaoPointGPS(em);
		DaoUtilisateur dUtilisateur = new DaoUtilisateur(em);
		DaoSport dSport = new DaoSport(em);
		
		/** Instanciation de la factory pour les entity*/
		EntityFactory ef = new EntityFactory();
		
		/** Creation des entity */
		Seance seance = new Seance();
		
		Utilisateur utilisateur = ef.createUtilisateur(
				"Anthony", "http://myAvatar.jpg", new Date(), 
				"http://facebook.com/myProfil", 174, "anthonylemee@gmail.com", 
				"LE MEE", "zinzin", new Character('H'), "http://twitter.com/myProfil", 65, seance);
		
		// Insertions en base 
		dUtilisateur.insert(utilisateur);
		
		Meteo meteo = ef.createMeteo("Sunny", 1, seance);
		dMeteo.insert(meteo);
		
		Sport sport 	= ef.createSport("Marathon", "Course à pieds", seance);
		
		// Insertions en base 
		dSport.insert(sport);
		
		/** Debut : Définition des relevés cardio */
		Set<Cardio> cardios = new HashSet<Cardio>();
		Cardio cardio1 	= ef.createCardio(120, seance);
		Cardio cardio2 	= ef.createCardio(110, seance);
		Cardio cardio3 	= ef.createCardio(180, seance);
		Cardio cardio4 	= ef.createCardio(160, seance);
		cardios.add(cardio1);
		cardios.add(cardio2);
		cardios.add(cardio3);
		cardios.add(cardio4);
		
		// Insertions en base 
		dCardio.insert(cardio1);
		dCardio.insert(cardio2);
		dCardio.insert(cardio3);
		dCardio.insert(cardio4);
		
		/** Fin : Définition des relevés cardio */
		
		/** Debut : Définition du parcours et des points GPS */
		Parcours parcours = new Parcours();
		
		Set<PointGPS> points = new HashSet<PointGPS>();
		
		parcours = ef.createParcours(42, 15, points, seance);
		
		// Insertions en base 
		dParcours.insert(parcours);
		PointGPS p1 = ef.createPointGPS(0, 0, 0, parcours);
		PointGPS p2 = ef.createPointGPS(0, 3, 8, parcours);
		points.add(p1);
		points.add(p2);
		
		// Insertions en base 
		dPointgps.insert(p1);
		dPointgps.insert(p2);
		
		/** Fin : Définition du parcours et des points GPS */
		
		seance = ef.createSeance(new Date(), new Date(), new Date(), (int) System.currentTimeMillis(), meteo, parcours, sport, utilisateur, cardios);
		
		// Insertions en base 
		dSeance.insert(seance);	
		
	} // main

} // class

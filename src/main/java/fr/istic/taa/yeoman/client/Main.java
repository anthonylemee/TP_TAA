package fr.istic.taa.yeoman.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.istic.taa.yeoman.dao.DAOCardio;
import fr.istic.taa.yeoman.dao.DAOMeteo;
import fr.istic.taa.yeoman.dao.DAOParcours;
import fr.istic.taa.yeoman.dao.DAOPersonne;
import fr.istic.taa.yeoman.dao.DaoPointGPS;
import fr.istic.taa.yeoman.dao.DaoSeance;
import fr.istic.taa.yeoman.dao.DaoSport;
import fr.istic.taa.yeoman.dao.DaoUtilisateur;
import fr.istic.taa.yeoman.entity.APersonne;
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
		EntityFactory ef = new EntityFactory();
		
		DAOCardio dCardio = new DAOCardio(em);
		
		
		Cardio cardio = ef.createCardio(10, null);
		dCardio.insert(cardio);
		em = emf.createEntityManager();
		dCardio = new DAOCardio(em);
		Cardio c = (Cardio) dCardio.findAll().get(0);
		System.out.println(c.log());
		c.setFrequency(123);
		c = (Cardio) dCardio.update(c);
		System.out.println(c.log());
		em = emf.createEntityManager();
		dCardio = new DAOCardio(em);
		c = (Cardio) dCardio.find(6);
		System.out.println("OK ?? " + c.log());
		
		em = emf.createEntityManager();
		Meteo m1 = ef.createMeteo("beau", 12, null);
		DAOMeteo dMeteo = new DAOMeteo(em);
		dMeteo.insert(m1);
		em = emf.createEntityManager();
		dMeteo = new DAOMeteo(em);
		Meteo m = (Meteo) dMeteo.findAll().get(0);
		
		em = emf.createEntityManager();
		Parcours p1 = ef.createParcours(12, 12, null, null);
		DAOParcours dParc = new DAOParcours(em);
		dParc.insert(p1);
		em = emf.createEntityManager();
		dParc = new DAOParcours(em);
		Parcours p = (Parcours) dParc.findAll().get(0);
		
		//faire de meme avec les autres classes
		
	} // main

} // class

package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.istic.taa.yeoman.entity.Parcours;

/**
 * Notre classe Daoparcours implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOParcours implements IDao<Parcours> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	private final Log logger = LogFactory.getLog(DAOParcours.class);
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe Daoparcours
	 */
	public DAOParcours() {
		if (DEBUG) logger.info("[Daoparcours] Instanciation de la DaoPersonne...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Parcours parcours) {

		if (DEBUG) logger.info("[DaoPersonne][INSERT] " + parcours.log());
		em.persist(parcours);
		
	}
	@Override
	public void delete(Parcours parcours) {
		
		if (DEBUG) logger.info("[DaoPersonne][DELETE] " + parcours.log());
		em.remove(parcours);
		
	}
	@Override
	public Parcours update(Parcours parcours) {
		
		if (DEBUG) logger.info("[DaoPersonne][UPDATE][Before] " + this.find(parcours.getId()).log());
		Parcours newparcours = em.merge(parcours);
		if (DEBUG) logger.info("[DaoPersonne][UPDATE][After]  " + newparcours.log());
		
		return newparcours;
		
	}
	@Override
	public Parcours find(long id) {

		if (DEBUG) logger.info("[DaoPersonne][FIND] " + id);
		return em.find(Parcours.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Parcours> findAll() {
		if (DEBUG) logger.info("[DaoPersonne][FINDALL] ");
		Query q = em.createQuery("select s from Parcours s");
		return (List<Parcours>)q.getResultList();
	}
	
} // class


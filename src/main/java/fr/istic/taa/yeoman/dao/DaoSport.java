package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.istic.taa.yeoman.entity.Sport;

/**
 * Notre classe DaoSport implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoSport implements IDao<Sport> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	private final Log logger = LogFactory.getLog(DaoSport.class);
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoSport
	 */
	public DaoSport () {
		
		if (DEBUG) logger.info("[DaoSport] Instanciation de la DaoSport...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Sport sport) {

		if (DEBUG) logger.info("[DaoSport][INSERT] " + sport.log());
		em.persist(sport);
		
	}
	@Override
	public void delete(Sport sport) {
		
		if (DEBUG) logger.info("[DaoSport][DELETE] " + sport.log());
		em.remove(sport);
		
	}
	@Override
	public Sport update(Sport sport) {
		
		if (DEBUG) logger.info("[DaoSport][UPDATE][Before] " + this.find(sport.getId()).log());
		Sport newSport = em.merge(sport);
		if (DEBUG) logger.info("[DaoSport][UPDATE][After]  " + newSport.log());
		
		return newSport;
		
	}
	@Override
	public Sport find(long id) {

		if (DEBUG) logger.info("[DaoSport][FIND] " + id);
		return em.find(Sport.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sport> findAll() {
		
		if (DEBUG) logger.info("[DaoSport][FINDALL] ");
		Query q = em.createQuery("select s from Sport s ORDER BY s.nom_sport ASC");
		return (List<Sport>)q.getResultList();
		
	}
	
} // class


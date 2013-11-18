package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.istic.taa.yeoman.entity.Cardio;

/**
 * Notre classe Daocardio implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOCardio implements IDao<Cardio> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	private final Log logger = LogFactory.getLog(DAOCardio.class);
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe Daocardio
	 */
	public DAOCardio() {
		if (DEBUG) logger.info("[Daocardio] Instanciation de la Daocardio...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Cardio cardio) {

		if (DEBUG) logger.info("[Daocardio][INSERT] " + cardio.log());
		em.persist(cardio);
		
	}
	@Override
	public void delete(Cardio cardio) {
		
		if (DEBUG) logger.info("[Daocardio][DELETE] " + cardio.log());
		em.remove(cardio);
		
	}
	@Override
	public Cardio update(Cardio cardio) {
		
		if (DEBUG) logger.info("[Daocardio][UPDATE][Before] " + this.find(cardio.getId()).log());
		Cardio newcardio = em.merge(cardio);
		if (DEBUG) logger.info("[Daocardio][UPDATE][After]  " + newcardio.log());
		
		return newcardio;
		
	}
	@Override
	public Cardio find(long id) {

		if (DEBUG) logger.info("[Daocardio][FIND] " + id);
		return em.find(Cardio.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cardio> findAll() {
		
		if (DEBUG) logger.info("[Daocardio][FINDALL] ");
		Query q = em.createQuery("select s from Cardio s");
		return (List<Cardio>)q.getResultList();
		
	}
	
} // class


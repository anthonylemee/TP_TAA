package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.istic.taa.yeoman.entity.Utilisateur;

/**
 * Notre classe DaoUtilisateur implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoUtilisateur implements IDao<Utilisateur> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	private final Log logger = LogFactory.getLog(DaoUtilisateur.class);
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoUtilisateur
	 */
	public DaoUtilisateur () {
		
		if (DEBUG) logger.info("[DaoUtilisateur] Instanciation de la DaoUtilisateur...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Utilisateur utilisateur) {

		if (DEBUG) logger.info("[DaoUtilisateur][INSERT] " + utilisateur.log());
		em.persist(utilisateur);
		
	}
	@Override
	public void delete(Utilisateur utilisateur) {
		
		if (DEBUG) logger.info("[DaoUtilisateur][DELETE] " + utilisateur.log());
		em.remove(utilisateur);
		
	}
	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		
		if (DEBUG) logger.info("[DaoUtilisateur][UPDATE][Before] " + this.find(utilisateur.getId()).log());
		Utilisateur newUtilisateur = em.merge(utilisateur);
		if (DEBUG) logger.info("[DaoUtilisateur][UPDATE][After]  " + newUtilisateur.log());
		
		return newUtilisateur;
		
	}
	@Override
	public Utilisateur find(long id) {

		if (DEBUG) logger.info("[DaoUtilisateur][FIND] " + id);
		return em.find(Utilisateur.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		
		if (DEBUG) logger.info("[DaoUtilisateur][FINDALL] ");
		Query q = em.createQuery("select u from Utilisateur u ORDER BY u.pseudo ASC");
		return (List<Utilisateur>)q.getResultList();
		
	}
	
} // class


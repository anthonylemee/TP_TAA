package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entity.Meteo;

/**
 * Notre classe Daometeo implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOMeteo implements IDao<Meteo> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe Daometeo
	 */
	public DAOMeteo() {
		if (DEBUG) System.out.println("[Daometeo] Instanciation de la DaoPersonne...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Meteo meteo) {

		if (DEBUG) System.out.println("[DaoPersonne][INSERT] " + meteo.log());
		em.persist(meteo);
		
	}
	@Override
	public void delete(Meteo meteo) {
		
		if (DEBUG) System.out.println("[DaoPersonne][DELETE] " + meteo.log());
		em.remove(meteo);
		
	}
	@Override
	public Meteo update(Meteo meteo) {
		
		if (DEBUG) System.out.println("[DaoPersonne][UPDATE][Before] " + this.find(meteo.getId()).log());
		Meteo newmeteo = em.merge(meteo);
		if (DEBUG) System.out.println("[DaoPersonne][UPDATE][After]  " + newmeteo.log());
		
		return newmeteo;
		
	}
	@Override
	public Meteo find(long id) {

		if (DEBUG) System.out.println("[DaoPersonne][FIND] " + id);
		return em.find(Meteo.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Meteo> findAll() {
		
		if (DEBUG) System.out.println("[DaoPersonne][FINDALL] ");
		Query q = em.createQuery("select s from Meteo s");
		return (List<Meteo>)q.getResultList();
		
	}
	
} // class


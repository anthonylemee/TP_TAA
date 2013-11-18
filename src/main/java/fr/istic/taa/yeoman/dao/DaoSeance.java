package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entity.Seance;

/**
 * Notre classe DaoSeance implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoSeance implements IDao<Seance> {

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
	 * Constructeur de la classe DaoSeance
	 */
	public DaoSeance () {
		
		if (DEBUG) System.out.println("[DaoSeance] Instanciation de la DaoSeance...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Seance seance) {

		if (DEBUG) System.out.println("[DaoSeance][INSERT] " + seance.log());
		em.persist(seance);
		
	}
	@Override
	public void delete(Seance seance) {
		
		if (DEBUG) System.out.println("[DaoSeance][DELETE] " + seance.log());
		em.remove(seance);
		
	}
	@Override
	public Seance update(Seance seance) {
		
		if (DEBUG) System.out.println("[DaoSeance][UPDATE][Before] " + this.find(seance.getId()).log());
		Seance newSeance = em.merge(seance);
		if (DEBUG) System.out.println("[DaoSeance][UPDATE][After]  " + newSeance.log());
		
		return newSeance;
		
	}
	@Override
	public Seance find(long id) {

		if (DEBUG) System.out.println("[DaoSeance][FIND] " + id);
		return em.find(Seance.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Seance> findAll() {
		
		if (DEBUG) System.out.println("[DaoSeance][FINDALL] ");
		Query q = em.createQuery("select s from Seance s ORDER BY s.date ASC");
		return (List<Seance>)q.getResultList();
		
	}
	
} // class


package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entity.APersonne;

/**
 * Notre classe Daopersonne implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOPersonne implements IDao<APersonne> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	//private final Logger logger = LoggerFactory.getLogger(DAOPersonne.class);
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe Daopersonne
	 */
	public DAOPersonne() {
		if (DEBUG) System.out.println("[Daopersonne] Instanciation de la DaoPersonne...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(APersonne personne) {

		if (DEBUG) System.out.println("[DaoPersonne][INSERT] " + personne.log());
		em.persist(personne);
		
	}
	@Override
	public void delete(APersonne personne) {
		
		if (DEBUG) System.out.println("[DaoPersonne][DELETE] " + personne.log());
		em.remove(personne);
		
	}
	@Override
	public APersonne update(APersonne personne) {
		
		if (DEBUG) System.out.println("[DaoPersonne][UPDATE][Before] " + this.find(personne.getId()).log());
		APersonne newpersonne = em.merge(personne);
		if (DEBUG) System.out.println("[DaoPersonne][UPDATE][After]  " + newpersonne.log());
		
		return newpersonne;
		
	}
	@Override
	public APersonne find(long id) {

		if (DEBUG) System.out.println("[DaoPersonne][FIND] " + id);
		return em.find(APersonne.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<APersonne> findAll() {
		
		if (DEBUG) System.out.println("[DaoPersonne][FINDALL] ");
		Query q = em.createQuery("select s from APersonne s");
		return (List<APersonne>)q.getResultList();
		
	}
	
} // class


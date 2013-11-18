package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoUtilisateur
	 */
	public DaoUtilisateur () {
		
		if (DEBUG) System.out.println("[DaoUtilisateur] Instanciation de la DaoUtilisateur...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Utilisateur utilisateur) {

		if (DEBUG) System.out.println("[DaoUtilisateur][INSERT] " + utilisateur.log());
		em.persist(utilisateur);
		
	}
	@Override
	public void delete(Utilisateur utilisateur) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][DELETE] " + utilisateur.log());
		em.remove(utilisateur);
		
	}
	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][UPDATE][Before] " + this.find(utilisateur.getId()).log());
		Utilisateur newUtilisateur = em.merge(utilisateur);
		if (DEBUG) System.out.println("[DaoUtilisateur][UPDATE][After]  " + newUtilisateur.log());
		
		return newUtilisateur;
		
	}
	@Override
	public Utilisateur find(long id) {

		if (DEBUG) System.out.println("[DaoUtilisateur][FIND] " + id);
		return em.find(Utilisateur.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][FINDALL] ");
		Query q = em.createQuery("select u from Utilisateur u ORDER BY u.pseudo ASC");
		return (List<Utilisateur>)q.getResultList();
		
	}
	
} // class


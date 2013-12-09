package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Utilisateur;
import fr.istic.taa.yeoman.entity.interfaces.IUtilisateur;

/**
 * Notre classe DaoUtilisateur implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoUtilisateur implements IDao<IUtilisateur> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private TransactionManager tm;
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoUtilisateur
	 */
	public DaoUtilisateur (EntityManager em) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur] Instanciation de la DaoUtilisateur...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public IUtilisateur insert(IUtilisateur utilisateur) {

		if (DEBUG) System.out.println("[DaoUtilisateur][INSERT] " + utilisateur.log());
		tm.persist(em,utilisateur);
		return utilisateur;
	}
	@Override
	public IUtilisateur delete(IUtilisateur utilisateur) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][DELETE] " + utilisateur.log());
		tm.remove(em,utilisateur);
		return null;
	}
	
	public IUtilisateur deleteById(int id) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][DELETE] " + id);
		em.getTransaction().begin();
		em.remove(find(id));
		em.getTransaction().commit();
		//em.createQuery("delete from Utilisateur u where u.id = " + id ).executeUpdate();
		//em.getTransaction().commit();
		return null;
	}

	@Override
	public IUtilisateur update(IUtilisateur utilisateur) {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][UPDATE][Before] " + this.find(utilisateur.getId()).log());
		tm.merge(em, utilisateur);
		return utilisateur;
		
	}
	@Override
	public IUtilisateur find(long id) {

		if (DEBUG) System.out.println("[DaoUtilisateur][FIND] " + id);
		return em.find(Utilisateur.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IUtilisateur> findAll() {
		
		if (DEBUG) System.out.println("[DaoUtilisateur][FINDALL] ");
		Query q = em.createQuery("select u from Utilisateur u ORDER BY u.pseudo ASC");
		return (List<IUtilisateur>)q.getResultList();
		
	}

	public Utilisateur findByLogin(String arg0) {
		if (DEBUG) System.out.println("[DaoUtilisateur][FINDALL] ");
		Query q = em.createQuery("select u from Utilisateur u where pseudo = '" + arg0 + "'");
		return (Utilisateur) q.getSingleResult();
	}
	
} // class


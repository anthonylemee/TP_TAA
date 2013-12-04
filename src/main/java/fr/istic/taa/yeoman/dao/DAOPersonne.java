package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.APersonne;
import fr.istic.taa.yeoman.entity.interfaces.IAPersonne;

/**
 * Notre classe Daopersonne implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOPersonne implements IDao<IAPersonne> {

	/** Attributs de la classe */
	@PersistenceContext//(type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	private TransactionManager tm;
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe Daopersonne
	 */
	public DAOPersonne(EntityManager em) {
		if (DEBUG) System.out.println("[Daopersonne] Instanciation de la DaoPersonne...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public IAPersonne insert(IAPersonne personne) {

		if (DEBUG) System.out.println("[DaoPersonne][INSERT] " + personne.log());
		tm.persist(em,personne);
		return personne;
	}
	@Override
	public IAPersonne delete(IAPersonne personne) {
		
		if (DEBUG) System.out.println("[DaoPersonne][DELETE] " + personne.log());
		tm.remove(em,personne);
		return personne;
	}
	@Override
	public IAPersonne update(IAPersonne personne) {
		
		if (DEBUG) System.out.println("[DaoPersonne][UPDATE][Before] " + this.find(personne.getId()).log());
		tm.merge(em, personne);		
		return personne;
		
	}
	@Override
	public IAPersonne find(long id) {
		if (DEBUG) System.out.println("[DaoPersonne][FIND] " + id);
		return em.find(APersonne.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IAPersonne> findAll() {
		
		if (DEBUG) System.out.println("[DaoPersonne][FINDALL] ");
		Query q = em.createQuery("select p from APersonne p");
		return (List<IAPersonne>)q.getResultList();
		
	}
	
} // class


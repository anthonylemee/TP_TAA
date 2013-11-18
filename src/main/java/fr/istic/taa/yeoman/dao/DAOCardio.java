package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entity.Cardio;

/**
 * Notre classe DaoCardio implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOCardio implements IDao<Cardio> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoCardio
	 */
	public DAOCardio(EntityManager em) {
		if (DEBUG) System.out.println("[DaoCardio] Instanciation de la DaoCardio...");
		this.em	= em;
		
	} // constructeur
	
	@Override
	public void insert(Cardio cardio) {

		if (DEBUG) System.out.println("[DaoCardio][INSERT] " + cardio.log());
		em.persist(cardio);
		
	}
	@Override
	public void delete(Cardio cardio) {
		
		if (DEBUG) System.out.println("[DaoCardio][DELETE] " + cardio.log());
		em.remove(cardio);
		
	}
	@Override
	public Cardio update(Cardio cardio) {
		
		if (DEBUG) System.out.println("[DaoCardio][UPDATE][Before] " + this.find(cardio.getId()).log());
		Cardio newcardio = em.merge(cardio);
		if (DEBUG) System.out.println("[DaoCardio][UPDATE][After]  " + newcardio.log());
		
		return newcardio;
		
	}
	@Override
	public Cardio find(long id) {

		if (DEBUG) System.out.println("[DaoCardio][FIND] " + id);
		return em.find(Cardio.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cardio> findAll() {
		
		if (DEBUG) System.out.println("[DaoCardio][FINDALL] ");
		Query q = em.createQuery("select s from Cardio s");
		return (List<Cardio>)q.getResultList();
		
	}
	
} // class


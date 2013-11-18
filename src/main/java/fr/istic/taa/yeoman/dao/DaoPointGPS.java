package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entity.PointGPS;

/**
 * Notre classe DaoPointGPS implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoPointGPS implements IDao<PointGPS> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	
	/** 
	 * @TODO Faire un fichier de configuration pour l'activation
	 * ou non du mode DEBUG 
	 */
	private final static Boolean DEBUG = true;
	
	/**
	 * Constructeur de la classe DaoPointGPS
	 */
	public DaoPointGPS (EntityManager em) {
		
		if (DEBUG) System.out.println("[DaoPointGPS] Instanciation de la DaoPointGPS...");
		this.em	= em;
		
	} // constructeur
	
	@Override
	public void insert(PointGPS pointGPS) {

		if (DEBUG) System.out.println("[DaoPointGPS][INSERT] " + pointGPS.log());
		em.persist(pointGPS);
		
	}
	@Override
	public void delete(PointGPS pointGPS) {
		
		if (DEBUG) System.out.println("[DaoPointGPS][DELETE] " + pointGPS.log());
		em.remove(pointGPS);
		
	}
	@Override
	public PointGPS update(PointGPS pointGPS) {
		
		if (DEBUG) System.out.println("[DaoPointGPS][UPDATE][Before] " + this.find(pointGPS.getId()).log());
		PointGPS newPointGPS = em.merge(pointGPS);
		if (DEBUG) System.out.println("[DaoPointGPS][UPDATE][After]  " + newPointGPS.log());
		
		return newPointGPS;
		
	}
	@Override
	public PointGPS find(long id) {

		if (DEBUG) System.out.println("[DaoPointGPS][FIND] " + id);
		return em.find(PointGPS.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PointGPS> findAll() {
		
		if (DEBUG) System.out.println("[DaoPointGPS][FINDALL] ");
		Query q = em.createQuery("select p from PointGPS p");
		return (List<PointGPS>)q.getResultList();
		
	}
	
} // class


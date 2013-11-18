package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.interfaces.IPointGPS;

/**
 * Notre classe DaoPointGPS implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoPointGPS implements IDao<IPointGPS> {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	TransactionManager tm;
	
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
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public IPointGPS insert(IPointGPS pointGPS) {
		if (DEBUG) System.out.println("[DaoPointGPS][INSERT] " + pointGPS.log());
		tm.persist(em, pointGPS);
		return pointGPS;
	}
	@Override
	public IPointGPS delete(IPointGPS pointGPS) {
		if (DEBUG) System.out.println("[DaoPointGPS][DELETE] " + pointGPS.log());
		tm.remove(em,pointGPS);
		return pointGPS;
	}
	@Override
	public IPointGPS update(IPointGPS pointGPS) {
		if (DEBUG) System.out.println("[DaoPointGPS][UPDATE][Before] " + this.find(pointGPS.getId()).log());
		tm.merge(em, pointGPS);
		return pointGPS;
	}
	@Override
	public IPointGPS find(long id) {
		if (DEBUG) System.out.println("[DaoPointGPS][FIND] " + id);
		return em.find(PointGPS.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IPointGPS> findAll() {
		if (DEBUG) System.out.println("[DaoPointGPS][FINDALL] ");
		Query q = em.createQuery("select p from PointGPS p");
		return (List<IPointGPS>)q.getResultList();
	}
	
} // class


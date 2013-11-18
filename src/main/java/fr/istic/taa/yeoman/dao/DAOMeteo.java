package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.interfaces.IMeteo;

/**
 * Notre classe Daometeo implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOMeteo implements IDao<IMeteo> {

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
	 * Constructeur de la classe Daometeo
	 */
	public DAOMeteo(EntityManager em) {
		
		if (DEBUG) System.out.println("[Daometeo] Instanciation de la DaoMeteo...");
		this.em = em;
		tm = new TransactionManager();
		
	} // constructeur
	
	@Override
	public IMeteo insert(IMeteo meteo) {

		if (DEBUG) System.out.println("[DaoMeteo][INSERT] " + meteo.log());
		tm.persist(em,meteo);
		return meteo;
	}
	@Override
	public IMeteo delete(IMeteo meteo) {
		
		if (DEBUG) System.out.println("[DaoMeteo][DELETE] " + meteo.log());
		tm.remove(em,meteo);
		return meteo;
	}
	@Override
	public IMeteo update(IMeteo meteo) {
		
		if (DEBUG) System.out.println("[DaoMeteo][UPDATE][Before] " + this.find(meteo.getId()).log());
		tm.merge(em, meteo);
		return meteo;
		
	}
	@Override
	public IMeteo find(long id) {

		if (DEBUG) System.out.println("[DaoMeteo][FIND] " + id);
		return em.find(Meteo.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IMeteo> findAll() {
		
		if (DEBUG) System.out.println("[DaoMeteo][FINDALL] ");
		Query q = em.createQuery("select m from Meteo m");
		return (List<IMeteo>)q.getResultList();
		
	}
	
} // class


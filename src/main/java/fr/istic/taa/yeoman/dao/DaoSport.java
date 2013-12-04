package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Sport;
import fr.istic.taa.yeoman.entity.interfaces.ISport;

/**
 * Notre classe DaoSport implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoSport implements IDao<ISport> {

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
	 * Constructeur de la classe DaoSport
	 */
	public DaoSport (EntityManager em) {
		
		if (DEBUG) System.out.println("[DaoSport] Instanciation de la DaoSport...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public ISport insert(ISport sport) {

		if (DEBUG) System.out.println("[DaoSport][INSERT] " + sport.log());
		tm.persist(em,sport);
		return sport;
	}
	@Override
	public ISport delete(ISport sport) {
		
		if (DEBUG) System.out.println("[DaoSport][DELETE] " + sport.log());
		tm.remove(em,sport);
		return sport;
	}
	@Override
	public ISport update(ISport sport) {
		
		if (DEBUG) System.out.println("[DaoSport][UPDATE][Before] " + this.find(sport.getId()).log());
		tm.merge(em, sport);
		return sport;
		
	}
	@Override
	public ISport find(long id) {

		if (DEBUG) System.out.println("[DaoSport][FIND] " + id);
		return em.find(Sport.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ISport> findAll() {
		
		if (DEBUG) System.out.println("[DaoSport][FINDALL] ");
		Query q = em.createQuery("select s from Sport s ORDER BY s.nom_sport ASC");
		return (List<ISport>)q.getResultList();
		
	}
	
} // class


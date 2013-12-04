package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.interfaces.ISeance;

/**
 * Notre classe DaoSeance implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoSeance implements IDao<ISeance> {

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
	 * Constructeur de la classe DaoSeance
	 */
	public DaoSeance (EntityManager em) {
		
		if (DEBUG) System.out.println("[DaoSeance] Instanciation de la DaoSeance...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public ISeance insert(ISeance seance) {

		if (DEBUG) System.out.println("[DaoSeance][INSERT] " + seance.log());
		tm.persist(em,seance);
		return seance;
	}
	@Override
	public ISeance delete(ISeance seance) {
		
		if (DEBUG) System.out.println("[DaoSeance][DELETE] " + seance.log());
		tm.remove(em,seance);
		return seance;
	}
	@Override
	public ISeance update(ISeance seance) {
		
		if (DEBUG) System.out.println("[DaoSeance][UPDATE][Before] " + this.find(seance.getId()).log());
		tm.merge(em, seance);
		return seance;
		
	}
	
	@Override
	public ISeance find(long id) {

		if (DEBUG) System.out.println("[DaoSeance][FIND] " + id);
		return em.find(Seance.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ISeance> findOfUser(String name) {

		if (DEBUG) System.out.println("[DaoSeance][findOfUser] " + name);
		Query q = em.createQuery("SELECT s FROM Seance s "); // WHERE s.utilisateur.pseudo = '" + name + "'"); 
		
		return (List<ISeance>)q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ISeance> findAll() {
		
		if (DEBUG) System.out.println("[DaoSeance][FINDALL] ");
		Query q = em.createQuery("select s from Seance s ORDER BY s.date ASC");
		return (List<ISeance>)q.getResultList();
		
	}
	
} // class


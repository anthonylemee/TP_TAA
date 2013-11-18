package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.interfaces.IParcours;

/**
 * Notre classe DaoParcours implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOParcours implements IDao<IParcours> {

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
	 * Constructeur de la classe DaoParcours
	 */
	public DAOParcours(EntityManager em) {
		
		if (DEBUG) System.out.println("[DaoParcours] Instanciation de la DaoParcours...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public IParcours insert(IParcours parcours) {

		if (DEBUG) System.out.println("[DaoParcours][INSERT] " + parcours.log());
		tm.persist(em,parcours);
		return parcours;
	}
	@Override
	public IParcours delete(IParcours parcours) {
		
		if (DEBUG) System.out.println("[DaoParcours][DELETE] " + parcours.log());
		tm.remove(em,parcours);
		return parcours;
	}
	@Override
	public IParcours update(IParcours parcours) {
		//if (DEBUG) System.out.println("[DaoParcours][UPDATE][Before] " + this.find(parcours.getId()).log());
		tm.merge(em,parcours);
		return parcours;
	}
	@Override
	public IParcours find(long id) {

		if (DEBUG) System.out.println("[DaoParcours][FIND] " + id);
		return em.find(Parcours.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IParcours> findAll() {
		if (DEBUG) System.out.println("[DaoParcours][FINDALL] ");
		Query q = em.createQuery("select p from Parcours p");
		return (List<IParcours>)q.getResultList();
	}
	
} // class


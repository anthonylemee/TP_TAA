package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.istic.taa.yeoman.client.TransactionManager;
import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.interfaces.ICardio;

/**
 * Notre classe DaoCardio implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DAOCardio implements IDao<ICardio> {

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
	 * Constructeur de la classe DaoICardio
	 */
	public DAOCardio(EntityManager em) {
		if (DEBUG) System.out.println("[DaoCardio] Instanciation de la DaoICardio...");
		this.em	= em;
		tm = new TransactionManager();
	} // constructeur
	
	@Override
	public ICardio insert(ICardio cardio) {
		if (DEBUG) System.out.println("[DaoCardio][INSERT] " + cardio.log());
		tm.persist(em, cardio);
		return cardio;
	}
	@Override
	public ICardio delete(ICardio cardio) {
		if (DEBUG) System.out.println("[DaoCardio][DELETE] " + cardio.log());
		tm.remove(em,cardio);
		return cardio;
	}
	@Override
	public ICardio update(ICardio cardio) {
		if (DEBUG) System.out.println("[DaoCardio][UPDATE][Before] " + this.find(cardio.getId()).log());
		tm.merge(em,cardio);
		return cardio;
	}
	@Override
	public ICardio find(long id) {
		if (DEBUG) System.out.println("[DaoCardio][FIND] " + id);
		return em.find(Cardio.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ICardio> findAll() {
		if (DEBUG) System.out.println("[DaoCardio][FINDALL] ");
		Query q = em.createQuery("select c from Cardio c");
		return (List<ICardio>)q.getResultList();		
	}
	
} // class


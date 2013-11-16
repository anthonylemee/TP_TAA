package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.istic.taa.yeoman.entity.Seance;

/**
 * Notre classe DaoSeance implémentant les méthodes de l'interface IDao
 * et qui implémente les méthodes d'accès aux données de la base.
 * @author Anthony
 * @since 
 */
public class DaoSeance implements IDao {

	/** Attributs de la classe */
	@PersistenceContext
	private EntityManager em;
	private EntityManagerFactory emf;
	private final Log logger = LogFactory.getLog(DaoSeance.class);
	
	/**
	 * Constructeur de la classe DaoSeance
	 */
	public DaoSeance () {
		
		logger.info("Instanciation de la DaoSeance...");
		emf = Persistence.createEntityManagerFactory( "jpa" );
		em 	= emf.createEntityManager();
		
	} // constructeur
	
	@Override
	public void insert(Seance seance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Seance seance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Seance update(Seance seance) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Seance find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Seance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
} // class


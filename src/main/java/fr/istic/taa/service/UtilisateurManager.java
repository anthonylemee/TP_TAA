package fr.istic.taa.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;

import fr.istic.taa.yeoman.Utilisateur;

@Stateless(mappedName = "UserManager")
public class UtilisateurManager {

	@PersistenceContext(unitName = "persistant")
	private EntityManager entityManager = null;

	private EntityManagerFactory emf;

	public UtilisateurManager() {
		emf = Persistence.createEntityManagerFactory("persistant");
		entityManager = emf.createEntityManager();
	}

	public Collection<Utilisateur> getUsers() {
		Query findAllUsers = entityManager
				.createNamedQuery("Utilisateur.findAll");
		Collection users = findAllUsers.getResultList();
		return users;
	}

	public Utilisateur getUserById(long id) {
		Query queryProductsByName = entityManager
				.createNamedQuery("Utilisateur.findById");
		queryProductsByName.setParameter("id", id);
		Utilisateur utilisateur = (Utilisateur) queryProductsByName
				.getSingleResult();
		return utilisateur;
	}

	public Utilisateur removeById(int parseInt) {
		entityManager.remove(getUserById(parseInt));
		return null;
	}

	public Utilisateur set(Utilisateur u) {
		entityManager.persist(u);
		return getUserById(u.getId());
	}

	public void add(Utilisateur u) {
		entityManager.persist(u);
	}
	
	public void startTransaction(){
		entityManager.getTransaction().begin();
	}
	
	public void commit(){
		entityManager.getTransaction().commit();
	}
	
	public void close(){
		entityManager.close();
	}
}

package service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import fr.istic.taa.yeoman.Utilisateur;

@Stateless(mappedName = "UserManager")
public class UtilisateurManager {

	 @PersistenceContext(unitName = "persistant")
     private EntityManager entityManager = null;
     
	 public UtilisateurManager() {
		 
	 }


	public Collection<Utilisateur> getUsers() {
		return null;
	}


	public Utilisateur getUserById(int parseInt) {
		return null;
	}


	public Utilisateur removeById(int parseInt) {
		return null;
	}


	public Utilisateur set(int parseInt, Utilisateur u) {
		return null;
	}


	public boolean add(Utilisateur u) {
		return false;
	}
	
	
}

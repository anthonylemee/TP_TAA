package fr.istic.taa.yeoman.client;

import javax.persistence.EntityManager;

import fr.istic.taa.yeoman.entity.interfaces.EntityExt;

public class TransactionManager {

	public void persist(EntityManager em, EntityExt i){
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}
	
	public void remove(EntityManager em, EntityExt i){
		em.getTransaction().begin();
		em.remove(i);
		em.getTransaction().commit();
	}
	
	public void merge(EntityManager em, EntityExt i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}
	
}

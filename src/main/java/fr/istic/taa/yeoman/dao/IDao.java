package fr.istic.taa.yeoman.dao;

import java.util.List;

/**
 * Interface définissant le squelette d'un Dao
 * @author Jimmy DANO & Anthony LE MEE
 * @param <T>
 */
public interface IDao<T> {

	public void insert(T object);
	public void delete(T object);
	public T update(T object);
	public T find(long id);
	public List<T> findAll();
	
}

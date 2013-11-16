package fr.istic.taa.yeoman.dao;

import java.util.List;

import fr.istic.taa.yeoman.entity.Seance;

/**
 * Interface définissant le squelette d'un Dao
 * @author Jimmy DANO & Anthony LE MEE
 */
public interface IDao {

	public void insert(Seance seance);
	public void delete(Seance seance);
	public Seance update(Seance seance);
	public Seance find(long id);
	public List<Seance> findAll();
	
}

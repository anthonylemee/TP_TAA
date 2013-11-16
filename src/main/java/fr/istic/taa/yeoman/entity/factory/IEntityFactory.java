package fr.istic.taa.yeoman.entity.factory;

import java.util.Date;
import java.util.Set;

import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.Sport;

public interface IEntityFactory {
	
	public Cardio createCardio(Double frequency, Seance seance);
	public Meteo createMeteo(String weather, Integer humidity);
	public Parcours createParcours(Integer nbKilom, Integer speed, Set<PointGPS> pointsGPS, Seance seance);
	public PointGPS createPointGPS(Integer x, Integer y, Integer z);
	public Seance createSeance(Date date, Date beginDate, Date endDate, Integer time);
	public Sport createSport(String nom, String type);
	
}

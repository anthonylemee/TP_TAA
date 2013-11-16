package fr.istic.taa.yeoman.entity.factory;

import java.util.Date;
import java.util.Set;

import fr.istic.taa.yeoman.entity.Cardio;
import fr.istic.taa.yeoman.entity.Meteo;
import fr.istic.taa.yeoman.entity.Parcours;
import fr.istic.taa.yeoman.entity.PointGPS;
import fr.istic.taa.yeoman.entity.Seance;
import fr.istic.taa.yeoman.entity.Sport;

/**
 * Factory pour la création des Entités
 * @author Dano Jimmy et LE MEE Anthony
 */
public class EntityFactory implements IEntityFactory {

	@Override
	public Cardio createCardio(Double frequency, Seance seance) {
		return null;
	}

	@Override
	public Meteo createMeteo(String weather, Integer humidity) {
		return null;
	}

	@Override
	public Parcours createParcours(Integer nbKilom, Integer speed,
			Set<PointGPS> pointsGPS, Seance seance) {
		return null;
	}

	@Override
	public PointGPS createPointGPS(Integer x, Integer y, Integer z) {
		return null;
	}

	@Override
	public Seance createSeance(Date date, Date beginDate, Date endDate,
			Integer time) {
		return null;
	}

	@Override
	public Sport createSport(String nom, String type) {
		return null;
	}
	
	
} // class

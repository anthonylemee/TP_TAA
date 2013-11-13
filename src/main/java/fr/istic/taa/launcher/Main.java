package fr.istic.taa.launcher;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.istic.taa.service.UtilisateurManager;
import fr.istic.taa.yeoman.Utilisateur;

public class Main {

	public static void main(String[] args) {

		UtilisateurManager userManager = new UtilisateurManager();
		
		userManager.startTransaction();
		Utilisateur user = new Utilisateur();
		user.setFirst_name("jimmy");
		Date d = new Date();
		user.setBirthDate(new Date());
		userManager.add(user);
		userManager.commit();
		userManager.close();
	}
}

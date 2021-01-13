package org.issamdrmas.cinema;

import org.issamdrmas.cinema.Service.ICinemaInitService;
import org.issamdrmas.cinema.entites.Film;
import org.issamdrmas.cinema.entites.Salle;
import org.issamdrmas.cinema.entites.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
	
	@Autowired
	private ICinemaInitService iCinemaInitService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
		
		System.out.println("App started ...");
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
			
		iCinemaInitService.initCities();
		iCinemaInitService.initCinemas();
		iCinemaInitService.initSalles();
		iCinemaInitService.initPlaces();
		iCinemaInitService.initSeances();
		iCinemaInitService.initCategories();
		iCinemaInitService.initFilms();
		iCinemaInitService.initProjections();
		iCinemaInitService.initTickets();
		
	}

}

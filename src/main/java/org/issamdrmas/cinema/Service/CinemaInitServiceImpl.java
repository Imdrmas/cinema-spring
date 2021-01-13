package org.issamdrmas.cinema.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.issamdrmas.cinema.dao.CategoryRepository;
import org.issamdrmas.cinema.dao.CinemaRepository;
import org.issamdrmas.cinema.dao.FilmRepository;
import org.issamdrmas.cinema.dao.PlaceRepository;
import org.issamdrmas.cinema.dao.ProjectionRepository;
import org.issamdrmas.cinema.dao.SalleRepository;
import org.issamdrmas.cinema.dao.SeanceRepository;
import org.issamdrmas.cinema.dao.TicketRepository;
import org.issamdrmas.cinema.dao.CityRepository;
import org.issamdrmas.cinema.entites.Category;
import org.issamdrmas.cinema.entites.Cinema;
import org.issamdrmas.cinema.entites.Film;
import org.issamdrmas.cinema.entites.Place;
import org.issamdrmas.cinema.entites.Projection;
import org.issamdrmas.cinema.entites.Salle;
import org.issamdrmas.cinema.entites.Seance;
import org.issamdrmas.cinema.entites.Ticket;
import org.issamdrmas.cinema.entites.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {

	@Autowired
	private CityRepository villeRepository;

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private SeanceRepository seanceRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private ProjectionRepository projectionRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void initCities() {
		Stream.of("Paris", "Marseille", "Lyon", "Bordeaux", "Toulouse", "Strasbourg", "Nantes", "Nice", "Montpellier",
				"Lille").forEach(cityName -> {
					City city = new City();
					city.setName(cityName);
					villeRepository.save(city);
				});

	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(city -> {
			Stream.of("MegaRama", "IMax", "Fnoun", "Chaharazad", "Daoulizz", "UGC").forEach(cinemaName -> {
				Cinema cinema = new Cinema();
				cinema.setName(cinemaName);
				cinema.setNombreSalles((int) (3 + Math.random() * 7));
				cinema.setCity(city);
				cinemaRepository.save(cinema);
			});
		});

	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema -> {
			for (int i = 0; i < cinema.getNombreSalles(); i++) {
				Salle salle = new Salle();
				salle.setName("Salle " + i + 1);
				salle.setCinema(cinema);
				salle.setPlaceNumber((int) (15 + Math.random() * 20));
				salleRepository.save(salle);
			}
		});

	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getPlaceNumber(); i++) {
				Place place = new Place();
				place.setNumber(i + 1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});

	}

	@Override
	public void initSeances() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Stream.of("12:00", "15:00", "17:00", "19:00", "21:00").forEach(s -> {
			Seance seance = new Seance();
			try {
				seance.setStartTime(format.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});

	}

	@Override
	public void initCategories() {
		Stream.of("Histoire", "Action", "Fiction", "Drama").forEach(cat -> {
			Category category = new Category();
			category.setName(cat);
			categoryRepository.save(category);
		});

	}
	@Override
	public void initFilms() {
		Film film1 = new Film("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "https://zupimages.net/up/21/02/7vq5.jpg", "Francis Ford Coppola", "1994", "01H20");
		Film film2 = new Film("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.","https://zupimages.net/up/21/02/b0e6.jpg", "Frank Darabont", "1972", "01H30");
		Film film3 = new Film("The Dark Knight", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.","https://zupimages.net/up/21/02/hcko.jpg", "Francis Ford Coppola", "1974", "01H20" );
		Film film4 = new Film("12 Angry Men", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological","https://zupimages.net/up/21/02/u1h6.jpg", "Christopher Nolan", "2008", "01H40" );
		Film film5 = new Film("Schindler is List", "Made Oskar Schindler famous, showing how the factory owner saved 1,200 Jews from World War II concentration camps.","https://zupimages.net/up/21/02/gyi2.jpg", "Steven Spielberg", "1957", "01H30");
		Film film6 = new Film("The Lord of the Rings", "The Lord of the Rings is an epic high fantasy novel by the English author and scholar J. R. R. Tolkien. Set in Middle-earth, the world at some distant time in the", "https://zupimages.net/up/21/02/glw6.jpg", "Sidney Lumet", "1993", "01H20");
		Film film7 = new Film("Pulp Fiction", "il est connu pour son humour parfois macabre, ses dialogues abondants et souvent cultes, ses nombreuses références cinématographiques ou encore son goût pour la violence extrême.","https://zupimages.net/up/21/02/bqrf.jpg", "Peter Jackson", "1993", "01H40");
		Film film8 = new Film("The Good the Bad and the Ugly", "Alors que la guerre de Sécession fait rage aux Etats-Unis, trois bandits n'ont qu'une préoccupation : l'argent. Joe livre régulièrement à la justice son copain Tuco","https://zupimages.net/up/21/02/803q.jpg", "Quentin Tarantino", "2003", "01H30");
		Film film9 = new Film("The Hard Way", "Après la mort de son frère lors d'une mission en Roumanie, un ancien soldat forme une équipe pour traquer un mystérieux ennemi et accomplir sa vengeance.","https://zupimages.net/up/21/02/d4el.jpg", "Peter Sehr", "1994", "01H30" );
		Film film10 = new Film("Night Hunter", "Night Hunter est un film réalisé par David Raymond (II) avec Alexandra Daddario, Henry Cavill. Synopsis : Des forces de police traquent un prédateur en ligne","https://zupimages.net/up/21/02/xd2m.jpg", "Issamdrmas", "1966", "01H40" );

		List<Category> categories = categoryRepository.findAll();
		film1.setCategory(categories.get(new Random().nextInt(categories.size())));
		film2.setCategory(categories.get(new Random().nextInt(categories.size())));
		film3.setCategory(categories.get(new Random().nextInt(categories.size())));
		film4.setCategory(categories.get(new Random().nextInt(categories.size())));
		
		filmRepository.save(film1);
		filmRepository.save(film2);
		filmRepository.save(film3);
		filmRepository.save(film4);
		filmRepository.save(film5);
		filmRepository.save(film6);
		filmRepository.save(film7);
		filmRepository.save(film8);
		filmRepository.save(film9);
		filmRepository.save(film10);
  
	}

	@Override
	public void initProjections() {
		double[] prix = new double[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		List<Film> films = filmRepository.findAll();
		villeRepository.findAll().forEach(city -> {
			city.getCinemas().forEach(cinema -> {
				cinema.getSalles().forEach(salle -> {
					int index = new Random().nextInt(films.size());
					Film film = films.get(index);
					seanceRepository.findAll().forEach(seance -> {
						Projection projection = new Projection();
						projection.setDateProjection(new Date());
						projection.setFilm(film);
						projection.setPrice(prix[new Random().nextInt(prix.length)]);
						projection.setSalle(salle);
						projection.setSeance(seance);
						projectionRepository.save(projection);
					});
				});
			});
		});

	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(projection -> {
			projection.getSalle().getPlaces().forEach(place -> {
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrice(projection.getPrice());
				ticket.setProjection(projection);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});

	}

}

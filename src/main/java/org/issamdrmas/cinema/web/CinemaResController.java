package org.issamdrmas.cinema.web;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.issamdrmas.cinema.dao.FilmRepository;
import org.issamdrmas.cinema.dao.TicketRepository;
import org.issamdrmas.cinema.entites.Film;
import org.issamdrmas.cinema.entites.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CinemaResController {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping("findFilmById/{id}")
	public Film findFilmById(@PathVariable(name = "id") Long id) {
		return filmRepository.findById(id).orElse(null);
	}

	@PostMapping("/puyTickets")
	@Transactional
	public List<Ticket> puyTickets(@RequestBody TicketFrom ticketFrom) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ticketFrom.getTickets().forEach(idTick -> {
			Ticket ticket = ticketRepository.findById(idTick).orElse(null);
			ticket.setNameClient(ticketFrom.getNameClient());
			ticket.setReserve(true);
			ticketRepository.save(ticket);
			tickets.add(ticket);
		});
		return tickets;
	}

}

class TicketFrom {

	private String nameClient;
	private int codePayement;
	private List<Long> tickets = new ArrayList<Long>();

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public List<Long> getTickets() {
		return tickets;
	}

	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}

	public int getCodePayement() {
		return codePayement;
	}

	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}

}

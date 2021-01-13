package org.issamdrmas.cinema.entites;

import java.util.Collection;
import java.util.Date;


import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= {org.issamdrmas.cinema.entites.Projection.class})
public interface ProjectionProj {
	public long getId();
	public double getPrice();
	public Date getDateProjection();
	public Salle getSalle();
	public Film getFilm();
	public Seance getSeance();
	public Collection<Ticket> getTickets();

}

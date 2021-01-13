package org.issamdrmas.cinema.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double longitude, latitude, altitude;
	
	private int nombreSalles;

	@OneToMany(mappedBy = "cinema")
	private Collection<Salle> salles;
	
	@ManyToOne
	private City city;

	public Cinema() {
		super();
	}

	public Cinema(String name, double longitude, double latitude, double altitude, int nombreSalles,
			Collection<Salle> salles, City city) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.nombreSalles = nombreSalles;
		this.salles = salles;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public int getNombreSalles() {
		return nombreSalles;
	}

	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


}

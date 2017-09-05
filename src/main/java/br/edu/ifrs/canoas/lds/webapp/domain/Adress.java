package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adress {

	@Id
	@GeneratedValue
	private String id;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String street;
	@NotNull(message="field.required") @NotBlank(message="field.empty") 
	private Long streetNumber;
	@NotNull(message="field.required")
	private String complements;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String neighborhood;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String city;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String state;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String zipcode;
	
	public Adress(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Long streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getComplements() {
		return complements;
	}

	public void setComplements(String complements) {
		this.complements = complements;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}

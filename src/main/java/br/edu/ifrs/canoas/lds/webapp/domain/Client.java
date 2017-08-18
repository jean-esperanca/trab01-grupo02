package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * "Cliente" in portuguese
 * Created by Edward Ramos Aug/10/2017.
 * 
 * Altered by Edward Ramos Aug/14/2017
 */
@Entity
public class Client {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String lastName;
	@NotNull @Email
	private String email;
	@NotNull
	private String phone;
	@NotNull
	private String cpf;
	@NotNull
	private String street;
	@NotNull
	private Long streetNumber;
	
	private String complements;
	@NotNull
	private String neighborhood;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String zipcode;
	
	public Client(){}
	public Client(Long id, String name, String lastName, String email, String phone, String cpf, String street,
			Long streetNumber, String complements, String neighborhood, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.street = street;
		this.streetNumber = streetNumber;
		this.complements = complements;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getNeighborhood() {
		return neighborhood;
	}
	public String getComplements() {
		return complements;
	}
	public void setComplements(String complements) {
		this.complements = complements;
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

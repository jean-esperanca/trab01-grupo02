package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

/**
 * "Cliente" in portuguese
 * Created by Edward Ramos Aug/10/2017.
 * 
 * Altered by Edward Ramos Aug/14/2017
 */
@Entity
public class Client {

	//TODO RNG002 - Informações do Cliente
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String name;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String lastName;
	@NotNull(message="field.required") @NotEmpty(message="field.empty") @Email(message="error.email")
	private String email;
	@NotNull(message="field.required") @NotEmpty(message="field.empty")
	private String phone;
	@NotNull(message="field.required") @NotEmpty(message="field.empty") @CPF(message="error.cpf") @Column(unique=true)
	private String cpf;
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
	@ManyToOne
	private Adress adress;
	
	@OneToMany
	private List<Purchase> purchases;

	public Client(){}

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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}

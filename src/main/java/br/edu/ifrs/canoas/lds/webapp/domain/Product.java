package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * "Produto" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}")
	private String name;
	
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}")
	private String description;
	
	
	@ManyToOne
	private Category category;
	
	@NotNull(message="{field.required}") @Min(1) 
	private Double value;
	
	@NotNull(message="{field.required}") @Min(1) 
	private Integer quantity;
	@ManyToOne
	private Provider provider;

	@ManyToMany(mappedBy = "products")
	private List<Purchase> purchases;


	public Product(){}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}

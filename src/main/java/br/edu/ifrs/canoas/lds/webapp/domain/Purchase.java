package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * "Pedido" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 * Implemented by Lauro Pereira Aug/18/2017
 */

@Entity
public class Purchase {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Client client;

	@ManyToMany
	private List<Product> products;

	private Double price;
	private Date purchaseDate;

	public Purchase() {}


	public Purchase(Client purchase, List<Product> products, double price, Date date) {
		this.client = purchase;
		this.products = products;
		this.price = price;
		this.purchaseDate = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {return client;}

	public void setClient(Client purchase) {this.client = purchase;}

	public List<Product> getProducts() {return products;}

	public void setProducts(List<Product> products) {this.products = products;}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}

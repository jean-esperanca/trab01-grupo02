package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * "Pedido" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 * Implemented by Lauro Pereira Aug/18/2017
 */

@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Client order;

	@ManyToMany
	private List<Product> products;
	private double price;
	private Date date;

	public Order() {}

	public Order(Client order, List<Product> products, double price, Date date) {
		this.order = order;
		this.products = products;
		this.price = price;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return order;
	}

	public void setClient(Client order) {
		this.order = order;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

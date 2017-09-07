package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
	@NotNull(message="{field.required}")
	private Client client;

	@ManyToMany
	@NotNull(message="{field.required}")
	private List<Product> products;

	@NotNull(message="{field.required}")
	private Double price;

	@NotNull(message="{field.required}")
	private Date purchaseDate;

	@Null
	private Date completionDate;

	@ManyToOne
	@NotNull(message="{field.required}")
	private PurchaseStatus purchaseStatus;

	public Purchase() {}

	public Purchase(Client purchase, List<Product> products, double price, Date date, Date completionDate, PurchaseStatus purchaseStatus) {
		this.client = purchase;
		this.products = products;
		this.price = price;
		this.purchaseDate = date;
		this.completionDate = completionDate;
		this.purchaseStatus = purchaseStatus;

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

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
}

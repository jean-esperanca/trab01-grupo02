package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * "Pedido" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 */
@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;
}
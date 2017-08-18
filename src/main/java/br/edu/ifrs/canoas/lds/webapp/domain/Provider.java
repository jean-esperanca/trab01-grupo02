package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * "Fornecedor" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 */
@Entity
public class Provider {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Provider(){}

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
	
	
}

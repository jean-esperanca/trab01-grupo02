package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * "Categoria" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 */
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Category(){}
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//Getters 'n' Setters
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

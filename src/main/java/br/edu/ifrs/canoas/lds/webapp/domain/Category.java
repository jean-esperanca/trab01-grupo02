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
}

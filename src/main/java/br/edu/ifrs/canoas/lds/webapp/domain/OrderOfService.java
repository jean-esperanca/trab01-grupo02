package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Edward Ramos Aug/10/2017.
 */
@Entity
public class OrderOfService {

	@Id
	@GeneratedValue
	private Long id;
	
	public OrderOfService(){
		
	}
}

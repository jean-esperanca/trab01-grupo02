package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * "Fornecedor" in portuguese
 * Created by Edward Ramos Aug/11/2017.
 * Changed by Jean Esperança Set/01/2017.
 */
@Entity
public class Provider {
	
	//TODO RGN006 - Informações do Fornecedor
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}")
	private String name;
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}") @CNPJ(message="{error.cnpj}") @Column(unique=true)
	private String cnpj;
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}") @Email(message="{error.email}")
	private String email;
	@NotNull(message="{field.required}") @NotEmpty(message="{field.empty}") @Size(min=13, max=14, message="{error.size}")
	private String phone;
		
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
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
}

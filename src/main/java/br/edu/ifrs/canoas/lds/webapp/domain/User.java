package br.edu.ifrs.canoas.lds.webapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

/**
 * Created by rodrigo on 2/21/17.
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private boolean active;
	private String password;
	private String experience;
	private String skill;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	@NotEmpty
	private String name;
	@Email @NotEmpty
	private String email;
	
    @OneToOne @JsonIgnore
    private File picture;


	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public String getStatus(){
		return this.active?"Sim" : "Não";
	}

}
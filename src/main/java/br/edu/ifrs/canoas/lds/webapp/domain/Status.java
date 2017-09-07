package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * "Status do pedido" in portuguese
 * Created by Lauro Pereira Sep/06/2017
 */

@Entity
public class Status {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "{field.required}")
    private String description;

    public Status(){}

    public Status(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package br.edu.ifrs.canoas.lds.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * "PurchaseStatus do pedido" in portuguese
 * Created by Lauro Pereira Sep/06/2017
 */

@Entity
public class PurchaseStatus {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "{field.required}")
    private String description;

    @OneToMany(mappedBy = "purchaseStatus")
    private List<Purchase> purchases;

    public PurchaseStatus(){}

    public PurchaseStatus(Long id, String description, List<Purchase> purchases){
        this.id = id;
        this.description = description;
        this.purchases = purchases;
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

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}

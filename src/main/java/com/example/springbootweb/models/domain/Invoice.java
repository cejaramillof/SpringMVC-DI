package com.example.springbootweb.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

// Components and Controllers per default are singleton
@Component
//@ApplicationScope
//@RequestScope
// Prototype Scope - usualy for standalone applications (like bash apps) multiples instances in container
@SessionScope // Persist in http session should impl serializable - Dont execute predestroy
public class Invoice implements Serializable {

    private static final long serialVersionUID = -6729102301816590139L;

    @Autowired
    private Client client;

    @Autowired
    @Qualifier("ItemsInvoiceTwo")
    private List<ItemInvoice> items;

    @Value("${invoice.description}")
    private String description;

    // post construct for spring container
    @PostConstruct
    public void init() {
        client.setName(client.getName().concat(" ").concat("Eduardo"));
        description = description.concat(" of client: ").concat(client.getName());
    }

    // pre destroy for spring container
    @PreDestroy
    public void destroy() {
        System.out.println("Invoice destroyed ".concat(description));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ItemInvoice> getItems() {
        return items;
    }

    public void setItems(List<ItemInvoice> items) {
        this.items = items;
    }
}

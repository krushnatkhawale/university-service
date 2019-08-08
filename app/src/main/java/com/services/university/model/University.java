package com.services.university.model;

import javax.persistence.*;

@Table(name = "University")
@Entity
public class University {

    @Id
    String id;

    String name;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
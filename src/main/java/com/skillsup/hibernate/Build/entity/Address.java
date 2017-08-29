package com.skillsup.hibernate.Build.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ID_ADDRESS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ZIP")
    private String zip;

    public Address() {
    }

    public Address(String zip) {
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zip='" + zip + '\'' +
                '}';
    }
}

package com.skillsup.hibernate.Build.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @Column(name = "ID_ROOM")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_PERSON")
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;

    public Room() {
    }

    public Room(Person owner, Address address) {
        this.owner = owner;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

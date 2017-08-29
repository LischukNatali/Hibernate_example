package com.skillsup.hibernate.Build.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BUILD")
public class Build {

    @Id
    @Column(name = "ID_BUILD")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ID_PERSON")
    private List<Person> allPersons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ID_ROOM")
    private List<Room> allRooms;

    public Build() {
    }

    public Build(Address address, List<Person> allPersons, List<Room> allRooms) {
        this.address = address;
        this.allPersons = allPersons;
        this.allRooms = allRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(List<Room> allRooms) {
        this.allRooms = allRooms;
    }
}

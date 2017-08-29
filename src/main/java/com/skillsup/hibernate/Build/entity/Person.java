package com.skillsup.hibernate.Build.entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "ID_PERSON")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NUMBER_ROOM")
    private int NumberRoom;

    public Person() {
    }

    public Person(String lastName, int numberRoom) {
        this.lastName = lastName;
        NumberRoom = numberRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberRoom() {
        return NumberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        NumberRoom = numberRoom;
    }
}

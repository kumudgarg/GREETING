package com.myfirstapp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Greeting> greetings;

    public List<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(List<Greeting> greetings) {
        this.greetings = greetings;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /*public Set<Greeting> getGreetings() {
        return g
    }*/

   /* public void setGreetings(Greeting... greetings) {
        this.greetings = Stream.of(greetings).collect(Collectors.toSet());
        this.greetings.forEach(x -> x.setBookCategory(this));
    }*/

    @Override
    public String toString() {
        return  firstName+ " "+ lastName ;

    }
}



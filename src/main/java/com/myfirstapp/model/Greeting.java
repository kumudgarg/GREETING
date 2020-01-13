package com.myfirstapp.model;



;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long counter;
    private String message;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User users;

    public Greeting(){

    }
    public Greeting(long counter, String message) {
        this.message = message;
        this.counter = counter;

    }



    public long getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

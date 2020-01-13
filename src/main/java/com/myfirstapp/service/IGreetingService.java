package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ListIterator;


public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    ListIterator<Greeting> getGreetingAll();

    Greeting getGreetingUpdate(long id, String name);

    void getGreetingDelete(long id);
}

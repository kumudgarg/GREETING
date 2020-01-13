package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import com.myfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        Greeting greeting = new Greeting(counter.incrementAndGet(), message);
        //user.setGreetings(greeting);
        greeting.setUsers(user);
        //userRepository.save(user);
        return greetingRepository.save(greeting);
    }


    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public ListIterator<Greeting> getGreetingAll() {
        return greetingRepository.findAll().listIterator();

    }

    @Override
    public Greeting getGreetingUpdate(long id, String name) {
        String message = String.format(template, name);
        Optional<Greeting> checkId = greetingRepository.findById(id);
        if (checkId.isPresent()){
            checkId.get().setMessage(message);
            return greetingRepository.save(checkId.get());
        }
        return null;
    }

    @Override
    public void getGreetingDelete(long id) {
        Optional<Greeting> checkId = greetingRepository.findById(id);
        if (checkId.isPresent())
            greetingRepository.deleteById(id);
    }
}

package com.myfirstapp.controller;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;


    @PostMapping("/greeting/post/")
    public Greeting addgreeting1(@RequestBody User user){
        return greetingService.addGreeting(user);

    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable long id){
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/greeting/get/all")
    public ListIterator<Greeting> getGreetingAll(){
        ListIterator<Greeting> greetingAll = greetingService.getGreetingAll();
        return greetingAll;
    }


    @PutMapping("/greeting/put/{id}")
    public Greeting getGreetingUpdate(@PathVariable long id,@RequestParam(value = "name", defaultValue = "world") String name){
        return greetingService.getGreetingUpdate(id,name);
    }

    @DeleteMapping("/greeting/delete/{id}")
    public void getGreetingDelete(@PathVariable long id){
        greetingService.getGreetingDelete(id);
    }



}

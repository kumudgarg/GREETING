package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.graalvm.compiler.options.OptionType.User;
import static org.junit.Assert.*;

public class GreetingServiceTest {

    @Test
    public void addGreeting() {
        User user = new User();
        user.setFirstName("");
        user.setLastName("");
        GreetingService greetingService = new GreetingService();
        Greeting greeting = greetingService.addGreeting(user);
        Assert.assertEquals("Hello World",greeting.getMessage());
    }
}
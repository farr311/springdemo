package de.telran.springdemo.controller;

import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    @Autowired
    private GreetingService service;

    @RequestMapping(method = RequestMethod.POST, path = "/greet")
    public int createGreeting(@RequestBody Greeting greeting) {
        return service.create(greeting);
    }

    @GetMapping("/greet/{id}")
    public String getGreeting(@PathVariable int id) {
        return service.get(id);
    }

    @PatchMapping("/greet/{id}")
    public void modifyGreeting(@PathVariable int id, @RequestParam int count) {
        service.update(id, count);
    }
}
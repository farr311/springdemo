package de.telran.springdemo.controller;

import de.telran.springdemo.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    //POST GET PUT PATCH DELETE

    private static final List<Greeting> list = new ArrayList<>();

    @PostMapping("/greet")
    public int createGreeting(@RequestBody Greeting greeting) {
        list.add(greeting);
        return list.size() - 1;
    }

    @GetMapping("/greet/{id}")
    public String greet(@PathVariable int id) {
        Greeting g = list.get(id);
        return ("Hello  " + g.getValue() + "").repeat(g.getCount());
    }

    @PatchMapping("/greet/{id}")
    public void modifyGreeting(
            @PathVariable int id,
            @RequestParam int count) {

        list.get(id).setCount(count);
    }
}
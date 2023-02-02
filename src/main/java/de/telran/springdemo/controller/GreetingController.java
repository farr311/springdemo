package de.telran.springdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    //POST GET PUT PATCH DELETE

    @GetMapping("/greeteveryone")
    public String greet() {
        return "Hello world";
    }

    @GetMapping("/greetsomeone/{val}") // .../greetsomeone/world
    public String greetSomeone1(@PathVariable("val") String value) {
        return "Hello " + value.repeat(2);
    }

    @GetMapping("/greetsomeone/{val1}/{val2}") // .../greetsomeone/world
    public String doubleGreet(
            @PathVariable("val1") String value1,
            @PathVariable("val2") String value2) {
        return "Hello " + value1 + " " + value2;
    }

    @GetMapping("/greetsomeone/{val1}/{val2}/params") // .../greetsomeone/world
    public String doubleGreetWithParams(
            @PathVariable("val1") String value1,
            @PathVariable("val2") String value2,
            @RequestParam("count") int count) {
        return ("Hello " + value1 + " " + value2 + "<br>").repeat(count);
    }

    //users/public/documents/page.html

    @GetMapping("/greetsomeone") // .../greetsomeone?val=...
    public String greetSomeone2(@RequestParam("val") String value) {
        return "REQUEST PARAM: Hello " + value;
    }
}
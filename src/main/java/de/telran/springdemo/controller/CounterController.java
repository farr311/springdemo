package de.telran.springdemo.controller;

import de.telran.springdemo.entity.Counter;
import de.telran.springdemo.service.CounterService;
import exception.IncorrectDataFormatException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/count")
@Validated
@SuppressWarnings("unused")
public class CounterController {
    @Autowired
    private CounterService service;

    @PostMapping()
    public ResponseEntity<Long> createGreeting(@RequestBody Counter counter) {
        //try {
        try {
            return new ResponseEntity<>(service.createOrGet(counter), HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            throw new IncorrectDataFormatException(e);
        }
       /* } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @GetMapping("/{id}")
    public ResponseEntity<Counter> getGreeting(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@ExceptionHandler({ConstraintViolationException.class})
    public void handleConstraintViolationException() {
        System.out.println("EXCEPTION FOUND");
    }*/
}
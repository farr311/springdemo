package de.telran.springdemo.service;

import de.telran.springdemo.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {
    private static final List<Greeting> list = new ArrayList<>();


    public int create(Greeting greeting) {
        list.add(greeting);
        return list.size() - 1;
    }

    public String get(int id) {
        Greeting g = list.get(id);
        return ("Hello  " + g.getValue() + "").repeat(g.getCount());
    }

    public void update(int id, int count) {
        list.get(id).setCount(count);
    }
}
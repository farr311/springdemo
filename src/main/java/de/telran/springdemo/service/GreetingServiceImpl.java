package de.telran.springdemo.service;

import de.telran.springdemo.entity.Greeting;
import de.telran.springdemo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("prod")
@SuppressWarnings("unused")
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository repository;


    public long create(Greeting greeting) {
        return repository.save(greeting).getId();
    }

    public Greeting get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void update(long id, int count) {
        Greeting g = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        g.setCount(count);
    }
}

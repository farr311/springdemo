package de.telran.springdemo.repository;

import de.telran.springdemo.model.Greeting;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@SuppressWarnings("unused")
public class GreetingRepositoryImpl implements GreetingRepository {

    private static final List<Greeting> list = new ArrayList<>();

    @Override
    public Optional<Greeting> find(long id) {
        Greeting value = null;

        try {
            value = list.get((int) id - 1);
        } catch (Exception ignored) {}

        return Optional.ofNullable(value);
    }

    @Override
    public long save(Greeting greeting) {
        int id = (int) greeting.getId();

        if (id == 0) {
            list.add(greeting);
            return list.size();
        }

        list.set(id, greeting);
        return id;
    }
}
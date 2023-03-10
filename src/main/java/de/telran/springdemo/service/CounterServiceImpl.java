package de.telran.springdemo.service;

import de.telran.springdemo.entity.Counter;
import de.telran.springdemo.repository.CountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@SuppressWarnings("unused")
public class CounterServiceImpl implements CounterService {

    @Autowired
    CountRepository repository;

    @Override
    public long createOrGet(@Valid Counter counter) {
        if (!existsWithGivenValue(counter.getCount())) {
            return repository.save(counter).getId();
        }

        List<Counter> list = repository.findByCount(counter.getCount());
        return Objects.requireNonNull(list.get(0)).getId();
    }

    @Override
    public Counter get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean existsWithGivenValue(int value) {
        return repository.existsCounterByCount(value);
    }


}

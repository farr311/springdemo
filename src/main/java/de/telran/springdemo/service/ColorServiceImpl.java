package de.telran.springdemo.service;

import de.telran.springdemo.entity.Color;
import de.telran.springdemo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository repository;
    @Override
    public long createOrGet(Color color) {
        // TODO: сохранить RgbaValue из данного color в репозитории через RgbaValueService

        return repository.save(color).getId();
    }

    @Override
    public Color get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean existsWithGivenValue(int value) {
        return false;
    }
}

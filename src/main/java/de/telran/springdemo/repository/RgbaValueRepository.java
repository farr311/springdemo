package de.telran.springdemo.repository;

import de.telran.springdemo.entity.RgbaValue;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface RgbaValueRepository extends JpaRepository<RgbaValue, Long> {
}


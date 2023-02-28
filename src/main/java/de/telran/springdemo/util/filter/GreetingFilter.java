package de.telran.springdemo.util.filter;

import de.telran.springdemo.entity.Color;
import de.telran.springdemo.entity.Counter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public class GreetingFilter {

    private FilterField<Long> id;

    private FilterField<String> value;

    private FilterField<Counter> counter;

    private FilterField<Color> color;
}

package de.telran.springdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "counter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "CUSTOM: Count must be equal to or more than 1")
    @Max(value = 10, message = "CUSTOM: Count must be equal to or less than 10")
    @NonNull
    @NotNull(message = "CUSTOM: Count cannot be null")
    @Column(name = "count_value", nullable = false, unique = true)
    private Integer count;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counter")
    private Set<Greeting> greetings;
}

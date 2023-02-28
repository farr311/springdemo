package de.telran.springdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @Min(1) @Max(10)
    @NonNull
    @NotEmpty
    @Column(name = "count_value", nullable = false, unique = true)
    private Integer count;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counter")
    private Set<Greeting> greetings;
}

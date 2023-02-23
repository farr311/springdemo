package de.telran.springdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "greeting")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @NonNull
    @Column(name = "greeting_value", nullable = false, length = 280)
    private String value;


    @ManyToOne
    private Counter counter;

    private Color color;

    /*
    * TODO: проставить JPA аннотации и аннотации javax.validation в классах Color и RgbaValue
    *  Реализовать контроллер для класса Color (для RgbaValue контроллер НЕ НУЖЕН)
    *  Реализовать сервисы и репозитории для обоих классов
    *  Связать эти сущности друг с другом и с сущностью Greeting
    * */
}

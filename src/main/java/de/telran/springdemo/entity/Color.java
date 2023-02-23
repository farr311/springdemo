package de.telran.springdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(
        name = "color",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "hex_value",
                                "rgba_value_id"
                        })
        })
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotNull
    @Pattern(regexp = "#[ABCDEF0-9](8)")
    @Column(name = "hex_value", nullable = false, unique = true, length = 9)
    private String hexValue;    //16ричное значение формата #AACB02CF

    @NonNull
    @NotNull
    @OneToOne
    private RgbaValue rgbaValue;
}

package com.example.movieticketsystem.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String moviename;
    @NotNull(message = "age cannot be empty")
    private Integer age;
    private String summary;
    @NotEmpty(message = "Time must be determined")
    private String genre;
    private String duration;
    @NotNull(message = "Days must be determined")
    @Enumerated(EnumType.STRING)
    private Day day;
    @NotEmpty(message = "Time must be determined")
    private String time;
    @NotNull(message = "location cannot be empty")
    @Enumerated
    private Location locations;
    @NotNull
    private Integer price;
    @NotNull
    private Integer seats;
}

package com.example.movieticketsystem.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message ="meal must be added it")
    @Column(unique = true)
    private String meal;
    @NotEmpty(message ="meal price must be added it")
    private Integer mealprice;
}

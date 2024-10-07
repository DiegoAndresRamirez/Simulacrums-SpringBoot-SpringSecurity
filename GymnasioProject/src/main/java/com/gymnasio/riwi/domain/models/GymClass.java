package com.gymnasio.riwi.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GymClass {  // Cambiado el nombre de la clase a GymClass
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "gym_id", referencedColumnName = "id")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private User trainer;

    @OneToMany(mappedBy = "gymClass", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}

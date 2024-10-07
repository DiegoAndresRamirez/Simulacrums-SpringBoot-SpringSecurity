package com.events.riwi.domain.models;

import com.events.riwi.utils.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets; // Relación con tickets

    @OneToMany(mappedBy = "organizator")
    private Set<VenueOrganizator> venueOrganizators; // Relación con VenueOrganizator
}


package com.events.riwi.domain.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "venue")
    private Set<EventVenue> eventVenues; // Relación con EventVenue

    @OneToMany(mappedBy = "venue")
    private Set<VenueOrganizator> venueOrganizators; // Relación con VenueOrganizator

//
//    @CreatedBy
//    private String createBy;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
}


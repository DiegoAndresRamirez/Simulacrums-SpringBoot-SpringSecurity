package com.events.riwi.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String address;
    private Date initialDate;
    private Date finalDate;
    private Long capacity;

    @OneToMany(mappedBy = "event")
    private Set<EventVenue> eventVenues; // Relación con EventVenue

    @OneToMany(mappedBy = "event")
    private Set<Ticket> tickets;

//    @CreatedBy
//    private String createBy;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
}


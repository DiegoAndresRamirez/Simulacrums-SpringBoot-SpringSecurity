package com.events.riwi.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueOrganizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)  // FK hacia Venue
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // FK hacia User (organizator)
    private User organizator;

    // Campos de auditoría
//    @CreatedBy
//    private String createdBy;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
}

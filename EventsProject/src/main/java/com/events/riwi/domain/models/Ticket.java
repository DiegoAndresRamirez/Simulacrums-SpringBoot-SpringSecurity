package com.events.riwi.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date initialDate;
    private Date finalDate;
    private Boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relación con User
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false) // Relación con Event
    private Event event;

//    @CreatedBy
//    private String createBy;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
}


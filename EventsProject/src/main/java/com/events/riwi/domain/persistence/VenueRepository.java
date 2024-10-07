package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}

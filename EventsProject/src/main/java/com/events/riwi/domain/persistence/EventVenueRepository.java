package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.EventVenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventVenueRepository extends JpaRepository<EventVenue, Long> {
}

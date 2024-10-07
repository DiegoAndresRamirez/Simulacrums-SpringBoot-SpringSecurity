package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.EventVenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventVenueRepository extends JpaRepository<EventVenue, Long> {
}

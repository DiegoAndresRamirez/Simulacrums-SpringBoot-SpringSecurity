package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    Venue findByName(String name);
}

package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

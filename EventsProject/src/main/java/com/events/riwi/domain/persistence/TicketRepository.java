package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

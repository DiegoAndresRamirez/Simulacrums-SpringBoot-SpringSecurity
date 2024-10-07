package com.events.riwi.infrastructure.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ITicketController {

    ResponseEntity<TicketCreateResponseDTO> createTicket(@RequestBody TicketCreateRequestDTO ticketCreateRequestDTO);

    ResponseEntity<List<TicketCreateRequestDTO>> getAllTickets();

    ResponseEntity<TicketCreateRequestDTO> getTicketById(@RequestParam Long id);

    ResponseEntity<String> deleteTicket(@RequestParam Long id);

    ResponseEntity<String> updateTicket(@RequestParam Long id, @RequestBody TicketCreateRequestDTO ticketCreateRequestDTO);

}

package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;

import java.util.List;

public interface ITicketService {

    TicketCreateResponseDTO createTicket(TicketCreateRequestDTO ticketCreateRequestDTO);

    List<TicketCreateRequestDTO> getAllTickets();

    TicketCreateRequestDTO getTicketById(Long id);

    String deleteTicket(Long id);

    String updateTicket(Long id, TicketCreateRequestDTO ticketCreateRequestDTO);
}

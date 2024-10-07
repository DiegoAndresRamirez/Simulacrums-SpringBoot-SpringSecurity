package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;

import java.util.List;

public interface ITicketService {

    TicketCreateResponseDTO createUser(TicketCreateRequestDTO ticketCreateRequestDTO);

    List<TicketCreateRequestDTO> getAllUsers();

    TicketCreateRequestDTO getUserById(Long id);

    String deleteUser(Long id);

    String updateUser(Long id, TicketCreateRequestDTO ticketCreateRequestDTO);
}

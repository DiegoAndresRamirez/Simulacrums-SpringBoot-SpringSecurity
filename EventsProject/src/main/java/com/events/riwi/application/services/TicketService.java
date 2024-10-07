package com.events.riwi.application.services;

import com.events.riwi.application.interfaces.ITicketService;
import com.events.riwi.domain.models.Ticket;
import com.events.riwi.domain.persistence.TicketRepository;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketCreateResponseDTO createUser(TicketCreateRequestDTO ticketCreateRequestDTO) {
        Ticket ticket = ticketRepository.findByCode(ticketCreateRequestDTO.getCode());
        if (ticket != null) {
            throw new EntityExistsException("Ticket already exists");
        }
        ticketRepository.save(Ticket.builder()
                .code(ticketCreateRequestDTO.getCode())
                .initialDate(ticketCreateRequestDTO.getInitialDate())
                .finalDate(ticketCreateRequestDTO.getFinalDate())
                .expired(ticketCreateRequestDTO.getExpired())
                .build());

        return new TicketCreateResponseDTO("Ticket creado con exito");
    }

    @Override
    public List<TicketCreateRequestDTO> getAllUsers() {
        List<TicketCreateRequestDTO> tickets = new ArrayList<>();

        ticketRepository.findAll().forEach(ticket -> {
            tickets.add(TicketCreateRequestDTO.builder()
                    .code(ticket.getCode())
                    .initialDate(ticket.getInitialDate())
                    .finalDate(ticket.getFinalDate())
                    .expired(ticket.getExpired())
                    .build());
        });
        if (tickets.isEmpty()) {
            throw new UsernameNotFoundException("Ticket not found");
        }
        return tickets;
    }

    @Override
    public TicketCreateRequestDTO getUserById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket == null) {
            throw new UsernameNotFoundException("Ticket not found");
        }
        return TicketCreateRequestDTO.builder()
                .code(ticket.getCode())
                .initialDate(ticket.getInitialDate())
                .finalDate(ticket.getFinalDate())
                .expired(ticket.getExpired())
                .build();
    }

    @Override
    public String deleteUser(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket == null) {
            throw new UsernameNotFoundException("Ticket not found");
        }
        ticketRepository.deleteById(id);
        return "Ticket deleted successfully";
    }

    @Override
    public String updateUser(Long id, TicketCreateRequestDTO ticketCreateRequestDTO) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket == null) {
            throw new UsernameNotFoundException("Ticket not found");
        }
        ticket.setId(id);
        ticket.setCode(ticketCreateRequestDTO.getCode());
        ticket.setInitialDate(ticketCreateRequestDTO.getInitialDate());
        ticket.setFinalDate(ticketCreateRequestDTO.getFinalDate());
        ticket.setExpired(ticketCreateRequestDTO.getExpired());
        ticketRepository.save(ticket);
        return "Ticket updated successfully";
    }
}

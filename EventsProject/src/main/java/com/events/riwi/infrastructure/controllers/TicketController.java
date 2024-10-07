package com.events.riwi.infrastructure.controllers;

import com.events.riwi.application.services.TicketService;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;
import com.events.riwi.infrastructure.interfaces.ITicketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController implements ITicketController {

    @Autowired
    private TicketService ticketService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TicketCreateResponseDTO> createTicket(@RequestBody TicketCreateRequestDTO ticketCreateRequestDTO) {
        try{
            return ResponseEntity.status(201).body(ticketService.createTicket(ticketCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<TicketCreateRequestDTO>> getAllTickets() {
        try{
            return ResponseEntity.status(200).body(ticketService.getAllTickets());
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TicketCreateRequestDTO> getTicketById(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(ticketService.getTicketById(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(ticketService.deleteTicket(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTicket(@RequestParam Long id, @RequestBody TicketCreateRequestDTO ticketCreateRequestDTO) {
        try{
            return ResponseEntity.status(200).body(ticketService.updateTicket(id, ticketCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
}

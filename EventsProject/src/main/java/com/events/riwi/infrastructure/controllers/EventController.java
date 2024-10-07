package com.events.riwi.infrastructure.controllers;

import com.events.riwi.application.services.EventService;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.interfaces.IEventController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController implements IEventController {

    @Autowired
    private EventService eventService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<EventCreateResponseDTO> createEvent(@RequestBody EventCreateRequestDTO eventCreateRequestDTO) {
        try{
            return ResponseEntity.status(201).body(eventService.createEvent(eventCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<EventCreateRequestDTO>> getAllEvents() {
        try{
            return ResponseEntity.status(200).body(eventService.getAllEvents());
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EventCreateRequestDTO> getEventById(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(eventService.getEventById(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(eventService.deleteEvent(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody EventCreateRequestDTO eventCreateRequestDTO) {
        try{
            return ResponseEntity.status(200).body(eventService.updateEvent(id, eventCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
}

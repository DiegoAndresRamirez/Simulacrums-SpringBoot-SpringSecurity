package com.events.riwi.application.services;

import com.events.riwi.application.interfaces.IEventService;
import com.events.riwi.domain.models.Event;
import com.events.riwi.domain.persistence.EventRepository;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventCreateResponseDTO createUser(EventCreateRequestDTO eventCreateRequestDTO) {
        Event event = eventRepository.findByName(eventCreateRequestDTO.getName());
        if (event != null) {
            return EventCreateResponseDTO.builder()
                    .message("Event already exists")
                    .build();
        }
        Event newEvent = Event.builder()
                .name(eventCreateRequestDTO.getName())
                .description(eventCreateRequestDTO.getDescription())
                .address(eventCreateRequestDTO.getAddress())
                .initialDate(eventCreateRequestDTO.getInitialDate())
                .finalDate(eventCreateRequestDTO.getFinalDate())
                .capacity(eventCreateRequestDTO.getCapacity())
                .build();

        eventRepository.save(newEvent);
        return EventCreateResponseDTO.builder()
                .message("Event created with the name: " + eventCreateRequestDTO.getName())
                .build();
    }

    @Override
    public List<EventCreateRequestDTO> getAllUsers() {
        List<EventCreateRequestDTO> events = new ArrayList<>();
        eventRepository.findAll().forEach(event -> {
            events.add(EventCreateRequestDTO.builder()
                    .name(event.getName())
                    .description(event.getDescription())
                    .address(event.getAddress())
                    .initialDate(event.getInitialDate())
                    .finalDate(event.getFinalDate())
                    .capacity(event.getCapacity())
                    .build());
        });
        if (events.isEmpty()) {
            throw new UsernameNotFoundException("Event not found");
        }
        return events;
    }

    @Override
    public EventCreateRequestDTO getUserById(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new UsernameNotFoundException("Event not found");
        }
        return EventCreateRequestDTO.builder()
                .name(event.getName())
                .description(event.getDescription())
                .address(event.getAddress())
                .initialDate(event.getInitialDate())
                .finalDate(event.getFinalDate())
                .capacity(event.getCapacity())
                .build();

    }

    @Override
    public String deleteUser(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new UsernameNotFoundException("Event not found");
        }
        eventRepository.deleteById(id);
        return "Event deleted successfully";
    }

    @Override
    public String updateUser(Long id, EventCreateRequestDTO eventCreateRequestDTO) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new UsernameNotFoundException("Event not found");
        }
        event.setId(id);
        event.setName(eventCreateRequestDTO.getName());
        event.setDescription(eventCreateRequestDTO.getDescription());
        event.setAddress(eventCreateRequestDTO.getAddress());
        event.setInitialDate(eventCreateRequestDTO.getInitialDate());
        event.setFinalDate(eventCreateRequestDTO.getFinalDate());
        event.setCapacity(eventCreateRequestDTO.getCapacity());
        eventRepository.save(event);

        return "Event updated successfully";
    }
}

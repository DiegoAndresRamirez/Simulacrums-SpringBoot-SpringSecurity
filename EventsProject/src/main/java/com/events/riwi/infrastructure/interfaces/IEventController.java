package com.events.riwi.infrastructure.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IEventController {

    ResponseEntity<EventCreateResponseDTO> createEvent(@RequestBody EventCreateRequestDTO eventCreateRequestDTO);

    ResponseEntity<List<EventCreateRequestDTO>> getAllEvents();

    ResponseEntity<EventCreateRequestDTO> getEventById(@RequestParam Long id);

    ResponseEntity<String> deleteUser(@RequestParam Long id);

    ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody EventCreateRequestDTO eventCreateRequestDTO);
}

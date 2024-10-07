package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;

import java.util.List;

public interface IEventService {
    EventCreateResponseDTO createEvent(EventCreateRequestDTO eventCreateRequestDTO);

    List<EventCreateRequestDTO> getAllEvents();

    EventCreateRequestDTO getEventById(Long id);

    String deleteEvent(Long id);

    String updateEvent(Long id, EventCreateRequestDTO eventCreateRequestDTO);
}

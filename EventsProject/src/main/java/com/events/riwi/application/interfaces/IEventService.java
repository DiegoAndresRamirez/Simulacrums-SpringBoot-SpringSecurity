package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.eventDtos.EventCreateRequestDTO;
import com.events.riwi.infrastructure.dto.eventDtos.EventCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;

import java.util.List;

public interface IEventService {
    EventCreateResponseDTO createUser(EventCreateRequestDTO eventCreateRequestDTO);

    List<EventCreateRequestDTO> getAllUsers();

    EventCreateRequestDTO getUserById(Long id);

    String deleteUser(Long id);

    String updateUser(Long id, EventCreateRequestDTO eventCreateRequestDTO);
}

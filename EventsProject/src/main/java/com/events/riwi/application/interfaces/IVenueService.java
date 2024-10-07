package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateRequestDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateResponseDTO;

import java.util.List;

public interface IVenueService {

    VenueCreateResponseDTO createVenue(VenueCreateRequestDTO venueCreateRequestDTO);

    List<VenueCreateRequestDTO> getAllVenues();

    VenueCreateRequestDTO getVenueById(Long id);

    String deleteVenue(Long id);

    String updateVenue(Long id, VenueCreateRequestDTO venueCreateRequestDTO);
}

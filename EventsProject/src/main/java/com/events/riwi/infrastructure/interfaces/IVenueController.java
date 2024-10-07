package com.events.riwi.infrastructure.interfaces;

import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateRequestDTO;
import com.events.riwi.infrastructure.dto.ticketDtos.TicketCreateResponseDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateRequestDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IVenueController {
    ResponseEntity<VenueCreateResponseDTO> createVenue(@RequestBody VenueCreateRequestDTO venueCreateRequestDTO);

    ResponseEntity<List<VenueCreateRequestDTO>> getAllVenues();

    ResponseEntity<VenueCreateRequestDTO> getVenueById(@RequestParam Long id);

    ResponseEntity<String> deleteVenue(@RequestParam Long id);

    ResponseEntity<String> updateVenue(@RequestParam Long id, @RequestBody VenueCreateRequestDTO venueCreateRequestDTO);
}

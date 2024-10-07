package com.events.riwi.infrastructure.controllers;

import com.events.riwi.infrastructure.interfaces.IVenueController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/venues")
public class VenueController implements IVenueController {
}

package com.events.riwi.infrastructure.controllers;

import com.events.riwi.infrastructure.interfaces.IEventController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
public class EventController implements IEventController {
}

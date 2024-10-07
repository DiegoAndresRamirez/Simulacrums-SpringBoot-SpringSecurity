package com.events.riwi.infrastructure.controllers;

import com.events.riwi.infrastructure.interfaces.ITicketController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController implements ITicketController {
}

package com.events.riwi.infrastructure.controllers;

import com.events.riwi.infrastructure.interfaces.IUserController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController implements IUserController {
}

package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelUser;
import com.riwi.library.domain.models.User;
import com.riwi.library.domain.persistence.UserRepository;
import com.riwi.library.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IModelUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String create(String name, String surname, String email, String password, String role) {

        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .role(Role.valueOf(role))
                .build();

        userRepository.save(user);
        return user.toString();
    }
}

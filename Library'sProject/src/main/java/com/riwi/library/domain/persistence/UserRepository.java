package com.riwi.library.domain.persistence;

import com.riwi.library.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

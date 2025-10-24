package com.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.busreservation.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name); // ✅ Required for login-based lookup
}

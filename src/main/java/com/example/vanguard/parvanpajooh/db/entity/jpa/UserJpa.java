package com.example.vanguard.parvanpajooh.db.entity.jpa;

import com.example.vanguard.parvanpajooh.db.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Users, Long> {
}

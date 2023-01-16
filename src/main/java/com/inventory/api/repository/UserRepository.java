package com.inventory.repository;

import java.util.Optional;

import com.inventory.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	
	Optional<User>findByUser(String user);
}

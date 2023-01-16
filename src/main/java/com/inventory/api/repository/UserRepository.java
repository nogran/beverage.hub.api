package com.inventory.api.repository;

import java.util.List;
import java.util.Optional;

import com.inventory.api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	List<User> findAll();
	Optional<User>findByEmail(String email);
}

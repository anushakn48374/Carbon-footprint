package com.texplore.carbonemissiontracker.repository;


import com.texplore.carbonemissiontracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

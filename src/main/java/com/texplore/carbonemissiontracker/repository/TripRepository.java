package com.texplore.carbonemissiontracker.repository;

import com.texplore.carbonemissiontracker.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}

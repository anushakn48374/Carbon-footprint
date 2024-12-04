package com.texplore.carbonemissiontracker.repository;

import com.texplore.carbonemissiontracker.model.Emission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmissionRepository extends JpaRepository<Emission, Integer> {
}

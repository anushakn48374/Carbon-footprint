package com.texplore.carbonemissiontracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "emission_data")
public class Emission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emission_id;
    @Column(name = "user_name", nullable = false)
    private String user_name;
    @Column(name = "trip_id", nullable = false)
    private int trip_id;
    @Column(name = "carbon_emission", nullable = false)
    private double carbon_emission;
    @Column(name = "lead_points", nullable = false)
    private double lead_points;

}

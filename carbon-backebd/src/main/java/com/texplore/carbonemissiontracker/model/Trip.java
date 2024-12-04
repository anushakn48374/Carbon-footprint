package com.texplore.carbonemissiontracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "trip_data")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trip_id;
    @Column(name = "trip_date", nullable = false)
    private Date trip_date;
    @Column(name = "distance_travel", nullable = false)
    private double distance_travel;
    @Column(name = "trans_mode", nullable = false)
    private String trans_mode;
    @Column(name = "start_location", nullable = true)
    private String start_location;
    @Column(name = "end_location", nullable = true)
    private String end_location;
}

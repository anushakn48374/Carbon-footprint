package com.texplore.carbonemissiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripResponse {

    private String user_name;
    private int trip_id;
    private double distance_travel;
    private String trans_mode;
    private double carbon_emission;
    private Date trip_date;
}

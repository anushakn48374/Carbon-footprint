package com.texplore.carbonemissiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripRequest {

    private String user_name;
    private double distance_travel;
    private String trans_mode;
}

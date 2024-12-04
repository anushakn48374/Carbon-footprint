package com.texplore.carbonemissiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderBoardResponse {
    private String user_name;
    private String distance_travel;
    private String carbon_emission;
    private double lead_points;

}

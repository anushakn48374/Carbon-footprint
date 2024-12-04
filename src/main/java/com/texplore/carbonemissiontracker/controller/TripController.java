package com.texplore.carbonemissiontracker.controller;

import com.texplore.carbonemissiontracker.dto.TripRequest;
import com.texplore.carbonemissiontracker.dto.TripResponse;
import com.texplore.carbonemissiontracker.dto.UserRequest;
import com.texplore.carbonemissiontracker.dto.UserResponse;
import com.texplore.carbonemissiontracker.model.Emission;
import com.texplore.carbonemissiontracker.model.Trip;
import com.texplore.carbonemissiontracker.model.User;
import com.texplore.carbonemissiontracker.service.EmissionService;
import com.texplore.carbonemissiontracker.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
@Slf4j
public class TripController {

    private final TripService tripService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TripResponse createTrip(@RequestBody TripRequest tripRequest) {
        log.info("Creating Trip: {}", tripRequest);
        TripResponse tripResponse = tripService.createTrip(tripRequest);
        log.info("Trip created: {}", tripResponse.getTrip_id());

        return tripResponse;
    }

}

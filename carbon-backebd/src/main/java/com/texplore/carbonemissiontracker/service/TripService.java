package com.texplore.carbonemissiontracker.service;

import com.texplore.carbonemissiontracker.dto.TripRequest;
import com.texplore.carbonemissiontracker.dto.TripResponse;
import com.texplore.carbonemissiontracker.model.Emission;
import com.texplore.carbonemissiontracker.model.Trip;
import com.texplore.carbonemissiontracker.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripService {

    private final EmissionService emissionService;

    private final TripRepository tripRepository;
    public TripResponse createTrip(TripRequest tripRequest) {

        Date utilDate = new Date();
        Timestamp sqlTimestamp = new Timestamp(utilDate.getTime());

        Trip trip = Trip.builder()
                .trans_mode(tripRequest.getTrans_mode())
                .trip_date(sqlTimestamp)
                .distance_travel(tripRequest.getDistance_travel())
                .build();
        tripRepository.save(trip);
        log.info("Trip {} is saved", trip.getTrip_id());

        Emission emission = emissionService.saveEmission(tripRequest, trip);
        log.info("Emission {} is saved", emission.getEmission_id());

        TripResponse tripResponse = new TripResponse();
        tripResponse.setUser_name(emission.getUser_name());
        tripResponse.setTrip_id(emission.getTrip_id());
        tripResponse.setCarbon_emission(emission.getCarbon_emission());
        tripResponse.setDistance_travel(trip.getDistance_travel());
        tripResponse.setTrip_date(trip.getTrip_date());

        return tripResponse;
    }
}

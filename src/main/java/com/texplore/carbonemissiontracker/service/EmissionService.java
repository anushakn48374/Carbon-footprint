package com.texplore.carbonemissiontracker.service;

import com.texplore.carbonemissiontracker.dto.TripRequest;
import com.texplore.carbonemissiontracker.helper.TransportData;
import com.texplore.carbonemissiontracker.model.Emission;
import com.texplore.carbonemissiontracker.model.Trip;
import com.texplore.carbonemissiontracker.repository.EmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmissionService {

    private final EmissionRepository emissionRepository;
    private static final int MAX_EMISSION = 190;

    public Emission saveEmission(TripRequest tripRequest, Trip trip) {
        Emission emission = new Emission();
        emission.setUser_name(tripRequest.getUser_name());
        emission.setTrip_id(trip.getTrip_id());
        double max_emission = MAX_EMISSION * trip.getDistance_travel();
        double carbon_emission = TransportData.getTransMode(tripRequest.getTrans_mode()).getFirst() * trip.getDistance_travel();
        double added_weightage = TransportData.getTransMode(tripRequest.getTrans_mode()).getLast() * trip.getDistance_travel();

        emission.setCarbon_emission(carbon_emission);
        emission.setLead_points((max_emission - carbon_emission + added_weightage)/100);

        return emissionRepository.save(emission);
    }
}

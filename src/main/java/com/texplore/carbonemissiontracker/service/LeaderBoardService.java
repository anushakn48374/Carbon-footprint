package com.texplore.carbonemissiontracker.service;

import com.texplore.carbonemissiontracker.dto.LeaderBoardResponse;
import com.texplore.carbonemissiontracker.helper.LeaderBoardRowMapper;
import com.texplore.carbonemissiontracker.model.LeaderBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaderBoardService {

    private final JdbcTemplate jdbcTemplate;

    public List<LeaderBoardResponse> getLeaderBoard() {

        String query = "SELECT e.user_name, t.distance_travel, e.carbon_emission, e.lead_points FROM emission_data e inner join trip_data t on e.trip_id = t.trip_id";

        List<LeaderBoard> leaderBoards = jdbcTemplate.query(query, new LeaderBoardRowMapper());

        Map<String, LeaderBoard> leaderBoardMap = new HashMap<>();

        for (LeaderBoard leaderBoard : leaderBoards) {
            if (leaderBoardMap.containsKey(leaderBoard.getUser_name())) {
                LeaderBoard existingLeaderBoard = leaderBoardMap.get(leaderBoard.getUser_name());
                existingLeaderBoard.setDistance_travel(existingLeaderBoard.getDistance_travel() + leaderBoard.getDistance_travel());
                existingLeaderBoard.setCarbon_emission(existingLeaderBoard.getCarbon_emission() + leaderBoard.getCarbon_emission());
                existingLeaderBoard.setLead_points(existingLeaderBoard.getLead_points() + leaderBoard.getLead_points());
                leaderBoardMap.put(leaderBoard.getUser_name(), existingLeaderBoard);
            } else {
                leaderBoardMap.put(leaderBoard.getUser_name(), leaderBoard);
            }
        }

        List<LeaderBoardResponse> sortedByPoint = new LinkedList<>();

        leaderBoardMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (int) ((int) o2.getLead_points() - o1.getLead_points())))
                .forEachOrdered(x -> sortedByPoint.add(
                        new LeaderBoardResponse(x.getValue().getUser_name(), x.getValue().getDistance_travel() + "KM", x.getValue().getCarbon_emission() + "gm", x.getValue().getLead_points())));

        return sortedByPoint;
    }
}
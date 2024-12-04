package com.texplore.carbonemissiontracker.controller;

import com.texplore.carbonemissiontracker.dto.LeaderBoardResponse;
import com.texplore.carbonemissiontracker.model.LeaderBoard;
import com.texplore.carbonemissiontracker.service.LeaderBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<LeaderBoardResponse> getLeaderBoard() {
        log.info("Fetching leaderboard:");
        return leaderBoardService.getLeaderBoard();
    }
}

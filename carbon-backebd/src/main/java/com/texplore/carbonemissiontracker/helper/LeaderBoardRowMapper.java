package com.texplore.carbonemissiontracker.helper;


import com.texplore.carbonemissiontracker.model.LeaderBoard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderBoardRowMapper implements RowMapper<LeaderBoard> {
    @Override
    public LeaderBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.setUser_name(rs.getString("user_name"));
        leaderBoard.setDistance_travel(rs.getDouble("distance_travel"));
        leaderBoard.setCarbon_emission(rs.getDouble("carbon_emission"));
        leaderBoard.setLead_points(rs.getDouble("lead_points"));
        return leaderBoard;

    }

}

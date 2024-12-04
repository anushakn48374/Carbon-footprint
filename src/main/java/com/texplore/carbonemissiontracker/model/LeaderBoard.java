package com.texplore.carbonemissiontracker.model;

public class LeaderBoard {
    private String user_name;
    private double distance_travel;
    private double carbon_emission;
    private double lead_points;

    public LeaderBoard(String user_name, double distance_travel, double carbon_emission, double lead_points) {
        this.user_name = user_name;
        this.distance_travel = distance_travel;
        this.carbon_emission = carbon_emission;
        this.lead_points = lead_points;
    }

    public LeaderBoard() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public double getDistance_travel() {
        return distance_travel;
    }

    public void setDistance_travel(double distance_travel) {
        this.distance_travel = distance_travel;
    }

    public double getCarbon_emission() {
        return carbon_emission;
    }

    public void setCarbon_emission(double carbon_emission) {
        this.carbon_emission = carbon_emission;
    }

    public double getLead_points() {
        return lead_points;
    }

    public void setLead_points(double lead_points) {
        this.lead_points = lead_points;
    }
}

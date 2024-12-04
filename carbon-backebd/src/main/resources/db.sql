CREATE DATABASE carbon_footprint_tracker;
use carbon_footprint_tracker;

CREATE TABLE user_data (
user_id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(255),
email_id VARCHAR(255),
mobile_no VARCHAR(255)
);

CREATE TABLE trip_data (
trip_id INT PRIMARY KEY AUTO_INCREMENT,
trip_date DATETIME,
start_location VARCHAR(255),
end_location VARCHAR(255),
distance_travel DECIMAL(10,2),
trans_mode VARCHAR(255)
);

CREATE TABLE emission_data (
emission_id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(255),
trip_id INT,
carbon_emission DECIMAL(10,2),
lead_points DECIMAL(10,2)
);

CREATE TABLE transport_data (
trans_mode INT PRIMARY KEY AUTO_INCREMENT,
trans_details VARCHAR(30),
co2_emission_fac INT
);

package com.texplore.carbonemissiontracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "user_name", nullable = false)
    private String user_name;
    @Column(name = "email_id", nullable = false)
    private String email_id;
    @Column(name = "mobile_no", nullable = false)
    private String mobile_no;

}
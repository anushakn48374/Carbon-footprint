package com.texplore.carbonemissiontracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String user_name;
    private String email_id;
    private String mobile_no;

}

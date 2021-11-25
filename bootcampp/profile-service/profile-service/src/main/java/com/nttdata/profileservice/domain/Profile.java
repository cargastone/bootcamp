package com.nttdata.profileservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private String id;
    private String typeProfile;
    private String montoMIn;
}

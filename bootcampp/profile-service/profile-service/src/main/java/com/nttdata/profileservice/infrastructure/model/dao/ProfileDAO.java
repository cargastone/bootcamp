package com.nttdata.profileservice.infrastructure.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "profiles")
public class ProfileDAO {
    @Id
    private String id;
    private String typeProfile;
    private String montoMIn;
}

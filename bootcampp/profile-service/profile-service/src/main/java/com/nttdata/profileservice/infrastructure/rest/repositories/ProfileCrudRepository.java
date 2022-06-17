package com.nttdata.profileservice.infrastructure.rest.repositories;

import com.nttdata.profileservice.infrastructure.model.dao.ProfileDAO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCrudRepository extends ReactiveMongoRepository<ProfileDAO, String> {
}

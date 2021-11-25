package com.nttdata.profileservice.application.impl;

import com.nttdata.profileservice.application.operations.ProfileOperations;
import com.nttdata.profileservice.domain.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProfileOperationsImpl implements ProfileOperations {
    @Override
    public Flux<Profile> findAll() {
        return null;
    }

    @Override
    public Mono<Profile> findById(String id) {
        return null;
    }

    @Override
    public Mono<Profile> save(Profile profile) {
        return null;
    }

    @Override
    public Mono<Profile> update(String id, Profile profile) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}

package com.nttdata.profileservice.application.operations;

import com.nttdata.profileservice.domain.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileOperations {

    public Flux<Profile> findAll();

    public Mono<Profile> findById(String id);

    public Mono<Profile> save(Profile profile);

    public Mono<Profile> update(String id,  Profile profile);

    public Mono<Void> delete(String id);

}

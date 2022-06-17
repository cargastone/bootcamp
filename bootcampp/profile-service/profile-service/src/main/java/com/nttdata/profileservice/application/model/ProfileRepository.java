package com.nttdata.profileservice.application.model;

import com.nttdata.profileservice.domain.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileRepository {

    public Flux<Profile> findAll();

    public Mono<Profile> findById(String id);

    public Mono<Profile> save(Profile profile);

    public Mono<Profile> update(String id,  Profile profile);

    public Mono<Void> delete(String id);
}

package com.nttdata.profileservice.application.impl;

import com.nttdata.profileservice.application.model.ProfileRepository;
import com.nttdata.profileservice.application.operations.ProfileOperations;
import com.nttdata.profileservice.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileOperationsImpl implements ProfileOperations {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Flux<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Mono<Profile> findById(String id) {
        return profileRepository.findById(id);
    }

    @Override
    public Mono<Profile> save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Mono<Profile> update(String id, Profile profile) {
        return profileRepository.update(id, profile);
    }

    @Override
    public Mono<Void> delete(String id) {
        return profileRepository.delete(id);
    }
}

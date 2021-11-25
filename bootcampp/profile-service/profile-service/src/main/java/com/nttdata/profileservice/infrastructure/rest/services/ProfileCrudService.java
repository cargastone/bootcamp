package com.nttdata.profileservice.infrastructure.rest.services;

import com.nttdata.profileservice.application.model.ProfileRepository;
import com.nttdata.profileservice.domain.Profile;
import com.nttdata.profileservice.infrastructure.model.dao.ProfileDAO;
import com.nttdata.profileservice.infrastructure.rest.repositories.ProfileCrudRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProfileCrudService implements ProfileRepository {


    @Autowired
    private ProfileCrudRepository profileCrudRepository;

    @Override
    public Flux<Profile> findAll() {
        return profileCrudRepository.findAll().map(this::toProfile);
    }

    @Override
    public Mono<Profile> findById(String id) {
        return profileCrudRepository.findById(id).map(this::toProfile);
    }

    @Override
    public Mono<Profile> save(Profile profile) {
        return profileCrudRepository.save(this.toProfileDAO(profile)).map(this::toProfile);
    }

    @Override
    public Mono<Profile> update(String id, Profile profile) {
        return profileCrudRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Profile not exist")))
                .flatMap(profileDAO -> {
                    profileDAO = toProfileDAO(profile);
                    return profileCrudRepository.save(profileDAO)
                            .map(this::toProfile);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return profileCrudRepository.deleteById(id);
    }



    //Mapper
    public ProfileDAO toProfileDAO(Profile profile) {
        ModelMapper modelMapper = new ModelMapper();
        ProfileDAO profileDAO = modelMapper.map(profile, ProfileDAO.class);
        return profileDAO;
    }

    public Profile toProfile(ProfileDAO profileDAO) {
        ModelMapper modelMapper = new ModelMapper();
        Profile profile = modelMapper.map(profileDAO, Profile.class);
        return profile;
    }
}

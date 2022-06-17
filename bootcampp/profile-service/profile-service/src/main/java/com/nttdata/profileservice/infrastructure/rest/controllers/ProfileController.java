package com.nttdata.profileservice.infrastructure.rest.controllers;

import com.nttdata.profileservice.application.operations.ProfileOperations;
import com.nttdata.profileservice.domain.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    @Autowired
    private ProfileOperations profileOperations;

    @GetMapping("list")
    public Flux<Profile> getAll(){
        return profileOperations.findAll();
    }

    @GetMapping("list/{id}")
    public Mono<Profile> getOne(@PathVariable String id){
        return profileOperations.findById(id);
    }

    @PostMapping("add")
    public Mono<Profile> save(@RequestBody Profile profile){
        return profileOperations.save(profile);
    }

    @PutMapping("update/{id}")
    public Mono<Profile> update(@PathVariable String id, @RequestBody Profile profile){
        return profileOperations.update(id, profile);
    }

    @DeleteMapping("remove/{id}")
    public Mono<Void> remove(@PathVariable String id){
        return profileOperations.delete(id);
    }

}

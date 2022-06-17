package com.nttdata.profileservice.infrastructure.rest.spring;

import com.nttdata.profileservice.application.model.ProfileRepository;
import com.nttdata.profileservice.infrastructure.rest.services.ProfileCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public ProfileRepository profileRepository() {
        return new ProfileCrudService();
    }
}

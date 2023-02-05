package com.cardest.backend.config;

import com.cardest.backend.adapter.out.user.UserMapper;
import com.cardest.backend.adapter.out.user.UserPersistenceAdapter;
import com.cardest.backend.adapter.out.user.UserRepository;
import com.cardest.backend.domain.port.in.UserUsesCases;
import com.cardest.backend.domain.port.out.UserDatabaseHandler;
import com.cardest.backend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class UserConfiguration {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = new UserMapper();
    private UserPersistenceAdapter userPersistenceAdapter;

    @Bean
    public UserDatabaseHandler getUserDataBaseHandler(){
        return new UserPersistenceAdapter(userRepository, userMapper);
    }

    @Bean
    public UserUsesCases getUserUsesCases(){
        userPersistenceAdapter = new UserPersistenceAdapter(userRepository, userMapper);
        return new UserService(userPersistenceAdapter);
    }

}

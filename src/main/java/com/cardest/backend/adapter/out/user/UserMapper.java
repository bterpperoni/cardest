package com.cardest.backend.adapter.out.user;

import com.cardest.backend.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    List<User> mapUserJpaEntityToModel(List<UserJpaEntity> userJpaEntities){
        /*
            Return a list of models from a list of JPA Entities
        */
        List<User> user_list = new ArrayList<>();
        for(UserJpaEntity entity : userJpaEntities){
            user_list.add(new User(entity.getId(),entity.getUsername(),entity.getEmail(),entity.getPassword(),entity.getAddress(),
                    entity.getLocality(),entity.getZipCode()));
        }
        return user_list;
    }

    User mapUserJpaEntityToModel(UserJpaEntity userJpaEntity){
        /*
            Return a model from a JPA Entity
         */
        if(userJpaEntity != null){
            User user = new User(userJpaEntity.getId(),userJpaEntity.getUsername(),userJpaEntity.getEmail(),
                    userJpaEntity.getPassword(),userJpaEntity.getAddress(),userJpaEntity.getLocality(),userJpaEntity.getZipCode());
            return user;
        }
        return null;
    }

    UserJpaEntity mapUserModelToJpa(User user, boolean newUser){
        /*
            Return a JPA Entity from a model
            Boolean newUser used to specify if it's a new entry or an update
         */
        UserJpaEntity userJpaEntity;
        if(newUser){
            userJpaEntity = new UserJpaEntity(user.getUsername(),user.getEmail(),user.getPassword(),
                    user.getAddress(),user.getLocality(),user.getZip_code());
        }
        else{
            /*
                Update user matching with provided ID
            */
            userJpaEntity = new UserJpaEntity(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),
                    user.getAddress(),user.getLocality(),user.getZip_code());
        }
        return userJpaEntity;
    }
}
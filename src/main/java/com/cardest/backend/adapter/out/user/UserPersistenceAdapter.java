package com.cardest.backend.adapter.out.user;

import com.cardest.backend.domain.model.User;
import com.cardest.backend.domain.port.out.UserDatabaseHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserDatabaseHandler {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getUserList(){
         /*
            Return a list containing all the users in the database
         */
        List<UserJpaEntity> userJpaEntities = userRepository.findAll();
        return userMapper.mapUserJpaEntityToModel(userJpaEntities);
    }

    @Override
    public User getUser(long id) {
        /*
            Return a specific user providing an ID
         */
        UserJpaEntity userJpaEntity = userRepository.findById(id).stream().findFirst().orElse(null);
        return userMapper.mapUserJpaEntityToModel(userJpaEntity);
    }

    @Override
    public User addUser(User user) {
        UserJpaEntity userJpaEntity = userRepository.save(userMapper.mapUserModelToJpa(user, true));
        return userMapper.mapUserJpaEntityToModel(userJpaEntity);
    }

    @Override
    public User updateUser(User user) {
        UserJpaEntity userJpaEntity = userRepository.save(userMapper.mapUserModelToJpa(user, false));
        return userMapper.mapUserJpaEntityToModel(userJpaEntity);
    }

    @Override
    public boolean deleteUser(long id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
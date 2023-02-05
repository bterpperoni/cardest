package com.cardest.backend.domain.service;

import com.cardest.backend.domain.model.User;
import com.cardest.backend.domain.port.in.UserUsesCases;
import com.cardest.backend.domain.port.out.UserDatabaseHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService implements UserUsesCases {

    @Getter
    private final UserDatabaseHandler userDatabaseHandler;
    @Override
    public List<User> getUserList() {
        return userDatabaseHandler.getUserList();
    }

    @Override
    public User getUser(long id) {
        return userDatabaseHandler.getUser(id);
    }

    @Override
    public User addUser(User user) {
        return userDatabaseHandler.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDatabaseHandler.updateUser(user);
    }

    @Override
    public boolean deleteUser(long id) {
        return userDatabaseHandler.deleteUser(id);
    }
}

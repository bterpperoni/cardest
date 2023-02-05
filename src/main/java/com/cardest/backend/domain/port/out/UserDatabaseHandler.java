package com.cardest.backend.domain.port.out;

import com.cardest.backend.domain.model.User;

import java.util.List;

public interface UserDatabaseHandler {
    List<User> getUserList();

    User getUser(long id);

    User addUser(User user);

    User updateUser(User user);

    boolean deleteUser(long id);
}

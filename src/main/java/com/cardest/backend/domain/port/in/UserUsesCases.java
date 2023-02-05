package com.cardest.backend.domain.port.in;

import com.cardest.backend.domain.model.User;

import java.util.List;

public interface UserUsesCases {
    List<User> getUserList();

    User getUser(long id);

    User addUser(User user);

    User updateUser(User user);

    boolean deleteUser(long id);
}

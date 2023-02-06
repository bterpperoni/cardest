package com.cardest.backend.adapter;

import com.cardest.backend.adapter.out.user.UserMapper;
import com.cardest.backend.adapter.out.user.UserPersistenceAdapter;
import com.cardest.backend.adapter.out.user.UserRepository;
import com.cardest.backend.domain.model.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserAdapterTest {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserPersistenceAdapter userPersistenceAdapter;

    @Test
    void getUserList(){
        userMapper = new UserMapper();
        userPersistenceAdapter = new UserPersistenceAdapter(userRepository,userMapper);
        List<User> userList = userPersistenceAdapter.getUserList();

        String name = "maxime";
        String mail = "maxime.curon@std.heh.be";
        String local = "Jemappes";
        long zip = 7012;

        assertEquals(name,userList.get(0).getUsername());
        assertEquals(mail,userList.get(0).getEmail());
        assertEquals(local,userList.get(0).getLocality());
        assertEquals(zip,userList.get(0).getZip_code());
    }
}

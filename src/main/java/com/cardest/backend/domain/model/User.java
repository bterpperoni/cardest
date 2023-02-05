package com.cardest.backend.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

    @Getter
    private final long id;
    @Getter
    private final String username;
    @Getter
    private final String email;
    @Getter
    private final String password;
    @Getter
    private final String address;
    @Getter
    private final String locality;
    @Getter
    private final long zip_code;

}


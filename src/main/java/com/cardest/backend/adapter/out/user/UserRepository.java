package com.cardest.backend.adapter.out.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {
     /*
        Inherits from JpaRepository which contains basic CRUD SQL operations
        Don't need to create them
     */
}

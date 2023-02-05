package com.cardest.backend.adapter.out.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "locality")
    private String locality;
    @Column(name = "zip_code")
    private long zipCode;

    public UserJpaEntity(long id, String username, String email, String password, String address, String locality, long zipCode) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.locality = locality;
        this.zipCode = zipCode;
    }

    public UserJpaEntity(String username, String email, String password, String address, String locality, long zipCode) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.locality = locality;
        this.zipCode = zipCode;
    }
    public UserJpaEntity() {}
}
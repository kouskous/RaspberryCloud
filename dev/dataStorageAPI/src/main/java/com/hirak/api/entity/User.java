package com.hirak.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    String firstName;

    String lastName;

    String job;

    String photo;

    String yearOfBirth;

    String facebookId;

    String facebookAccessToken;
}

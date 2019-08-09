package com.hirak.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @ManyToOne
    User user;

    @ManyToOne
    Subdivision subdivision;
}

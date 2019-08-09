package com.hirak.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @ManyToOne
    OpinionType opinionType;

    @ManyToOne
    User user;

    @ManyToOne
    Candidature candidature;

}

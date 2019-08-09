package com.hirak.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OpinionType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

}

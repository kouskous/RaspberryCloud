package com.igniter.dataStorageAPI.repository;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.entity.Actuator;
import com.igniter.dataStorageAPI.entity.Terminal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorRepository extends CrudRepository<Actuator, Integer> {
    public List<Actuator> findAll();
    public Actuator findById(int id);
	public List<Actuator> findByTerminal(Terminal terminal);
}

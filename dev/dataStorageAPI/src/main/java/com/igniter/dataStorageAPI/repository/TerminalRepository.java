package com.igniter.dataStorageAPI.repository;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.entity.Terminal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends CrudRepository<Terminal, Integer> {
    public List<Terminal> findAll();
    public Terminal findById(int id);
    public Terminal findOneBySerialNumber(String serialNumber);
	public List<Terminal> findByAccount(Account account);
    
}

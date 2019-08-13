package com.igniter.dataStorageAPI.repository;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    public List<Account> findAll();
    public Account findById(int id);
    public Account findByLogin(String login);
    
}

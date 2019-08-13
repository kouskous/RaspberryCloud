package com.igniter.dataStorageAPI.service;

import java.util.List;
import java.util.UUID;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class AuthenticationService {
    @Autowired
    private AccountRepository accountRepository;


    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public boolean createAccount(Account account){
        if(accountRepository.findByLogin(account.getLogin()) == null){
            UUID uuid = UUID.randomUUID();
            account.setToken(uuid.toString());
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAccountByLogin(String login){
        Account account = accountRepository.findByLogin(login);
        if(account != null){
            accountRepository.delete(account);
            return true;
        } else {
            return false;
        }
    }

    public String authenticate(String login, String password){
        Account account = accountRepository.findByLogin(login);
        if(account != null){
            return account.getToken();
        } else {
            return null;
        }
    }

    public Account getAccountById(int id){
        return accountRepository.findById(id);
    }
   
}

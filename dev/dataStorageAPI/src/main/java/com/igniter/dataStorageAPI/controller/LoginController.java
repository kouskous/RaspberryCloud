package com.igniter.dataStorageAPI.controller;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	public AuthenticationService authenticationService;

	@RequestMapping("/accounts")
	public List<Account> getAllAccounts() {
		return authenticationService.getAllAccounts();
	}

	public void login(){

	}

	@PostMapping("/account")
	public void register(@RequestBody Account account){
		authenticationService.createAccount(account);
	}

}

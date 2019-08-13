package com.igniter.dataStorageAPI.controller;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.entity.Terminal;
import com.igniter.dataStorageAPI.service.AuthenticationService;
import com.igniter.dataStorageAPI.service.TerminalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerminalController {

	@Autowired
	public AuthenticationService authenticationService;

	@Autowired
	public TerminalService terminalService;

	@GetMapping("/terminals")
	public List<Terminal> getAllTerminals() {
		return terminalService.getAllTerminals();
	}

	@PostMapping("/terminal")
	public Terminal generateTerminal(){
		return terminalService.createTerminal();
	}

	@PutMapping("/terminal")
	public void updateTerminal(@RequestBody Terminal terminal){
		terminalService.updateTerminal(terminal);
	}

	@PostMapping("/account/{idAccount}/registerTerminal")
	public void registerTerminal(@PathVariable int idAccount , @RequestBody Terminal terminal){
		Account account = authenticationService.getAccountById(idAccount);
		terminalService.registerTerminal(terminal, account);
	}

	@GetMapping("/account/{idAccount}/terminals")
	public List<Terminal> getAccountTerminals(@PathVariable int idAccount ){
		Account account = authenticationService.getAccountById(idAccount);
		return terminalService.getAccountTerminals(account);
	}
}

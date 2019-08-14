package com.igniter.dataStorageAPI.controller;

import java.util.List;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.entity.Actuator;
import com.igniter.dataStorageAPI.entity.Terminal;
import com.igniter.dataStorageAPI.service.ActuatorService;
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
public class ActuatorController {

	@Autowired
	public TerminalService terminalService;

	@Autowired
	public ActuatorService actuatorService;


	@PutMapping("/actuator")
	public void updateActuator(@RequestBody Actuator actuator){
		actuatorService.updateActuator(actuator);
	}

	@PostMapping("/terminal/{terminalId}/registerActuator")
	public void registerActuator(@PathVariable int terminalId , @RequestBody Actuator actuator){
		Terminal terminal = terminalService.getTerminalById(terminalId);
		actuatorService.registerActuator(actuator, terminal);
	}

	@GetMapping("/terminal/{terminalId}/actuators")
	public List<Actuator> getTerminalActuators(@PathVariable int terminalId ){
		Terminal terminal = terminalService.getTerminalById(terminalId);
		return actuatorService.getTerminalActuators(terminal);
	}
}

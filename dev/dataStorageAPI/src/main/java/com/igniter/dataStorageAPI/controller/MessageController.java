package com.igniter.dataStorageAPI.controller;

import java.util.ArrayList;
import com.igniter.dataStorageAPI.entity.Message;
import com.igniter.dataStorageAPI.service.ActuatorService;
import com.igniter.dataStorageAPI.service.TerminalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	public TerminalService terminalService;

	@Autowired
	public ActuatorService actuatorService;

	@PostMapping("/message")
	public ArrayList<String> processMessage(@RequestBody Message message) {
		ArrayList<String> destinationIdentifiers = new ArrayList<String>(); 

		if (message.getType().equals("ACTION_REQUEST")) {

		} else if (message.getType().equals("ACTION_RESPONSE")) {

		} else if (message.getType().equals("MESUREMENT")) {

		} else if (message.getType().equals("CONFIGURATION")) {

		}
		destinationIdentifiers.add("2214b3a0-78b3-428c-9cde-06e437ea6c1e");
		return destinationIdentifiers;
	}

}

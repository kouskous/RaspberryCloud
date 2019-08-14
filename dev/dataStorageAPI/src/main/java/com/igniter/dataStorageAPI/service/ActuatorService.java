package com.igniter.dataStorageAPI.service;

import java.util.List;
import com.igniter.dataStorageAPI.entity.Actuator;
import com.igniter.dataStorageAPI.entity.Terminal;
import com.igniter.dataStorageAPI.repository.ActuatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActuatorService {
    
    @Autowired
    private ActuatorRepository actuatorRepository;

    public List<Actuator> getAllActuators() {
        return actuatorRepository.findAll();
    }

    public Actuator registerActuator(Actuator actuator, Terminal terminal) {
        actuator.setTerminal(terminal);
        actuatorRepository.save(actuator);
        return actuator;
    }

    public void unregisterActuator(Actuator actuator) {
        Actuator dbActuator = actuatorRepository.findById(actuator.getId());
        dbActuator.setTerminal(null);
        actuatorRepository.save(dbActuator);
    }

    public List<Actuator> getTerminalActuators(Terminal terminal){
        return actuatorRepository.findByTerminal(terminal);
    }

	public void updateActuator(Actuator actuator) {
        Actuator dbActuator = actuatorRepository.findById(actuator.getId());
        dbActuator.setLabel(actuator.getLabel());
        actuatorRepository.save(dbActuator);
	}
}

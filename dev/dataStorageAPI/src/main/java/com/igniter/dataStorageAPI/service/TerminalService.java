package com.igniter.dataStorageAPI.service;

import java.util.List;
import java.util.UUID;

import com.igniter.dataStorageAPI.entity.Account;
import com.igniter.dataStorageAPI.entity.Terminal;
import com.igniter.dataStorageAPI.repository.AccountRepository;
import com.igniter.dataStorageAPI.repository.TerminalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TerminalRepository terminalRepository;

    public List<Terminal> getAllTerminals() {
        return terminalRepository.findAll();
    }

    public Terminal createTerminal() {
        Terminal terminal = new Terminal();
        UUID uuid = UUID.randomUUID();
        terminal.setKey(uuid.toString());
        uuid = UUID.randomUUID();
        terminal.setSerialNumber(uuid.toString());
        terminalRepository.save(terminal);
        return terminal;
    }

    public void registerTerminal(Terminal terminal, Account account) {
        Terminal dbTerminal = terminalRepository.findOneBySerialNumber(terminal.getSerialNumber());
        if (dbTerminal != null) {
            if (dbTerminal.getKey().equals(terminal.getKey())) {
                dbTerminal.setAccount(account);
                terminalRepository.save(dbTerminal);
            }
        }
    }

    public void unregisterTerminal(Terminal terminal) {
        Terminal dbTerminal = terminalRepository.findOneBySerialNumber(terminal.getSerialNumber());
        if (dbTerminal != null) {
            terminal.setAccount(null);
            terminalRepository.save(terminal);
        }
    }

    public void updateTerminal(Terminal terminal) {
        Terminal dbTerminal = terminalRepository.findOneBySerialNumber(terminal.getSerialNumber());
        if (dbTerminal != null) {
           dbTerminal.setLabel(terminal.getLabel());
           dbTerminal.setConnected(terminal.getConnected());
        }
    }

    public List<Terminal> getAccountTerminals(Account account){
        return terminalRepository.findByAccount(account);
    }

    public Terminal getTerminalById(int id){
        return terminalRepository.findById(id);
    }
}

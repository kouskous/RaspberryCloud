package com.hirak.api.service;

import java.util.List;

import com.hirak.api.entity.Division;
import com.hirak.api.entity.Subdivision;
import com.hirak.api.repository.DivisionRepository;
import com.hirak.api.repository.SubdivisionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class AdministrativeService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private SubdivisionRepository subdivisionRepository;

    public List<Division> getAllDivisions(){
        return divisionRepository.findAll();
    }

    public List<Subdivision> getAllSubDivisions(){
        return subdivisionRepository.findAll();
    }

    public List<Subdivision> getSubDivisionsBydivisionId(int divisionId){
        Division division = divisionRepository.findById(divisionId);
        return subdivisionRepository.findByDivision(division);
    }
}

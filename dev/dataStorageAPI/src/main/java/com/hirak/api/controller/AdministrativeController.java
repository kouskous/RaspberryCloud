package com.hirak.api.controller;

import java.util.List;

import com.hirak.api.entity.Division;
import com.hirak.api.entity.Subdivision;
import com.hirak.api.service.AdministrativeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrativeController {

	@Autowired
	public AdministrativeService administrativeService;

	@RequestMapping("/divisions")
	public List<Division> getAllDivisions() {
		return administrativeService.getAllDivisions();
	}

	@RequestMapping("/subdivisions/{divisionId}")
	public List<Subdivision> getSubDivisionsBydivisionId(@PathVariable(value = "divisionId") int divisionId) {
		return administrativeService.getSubDivisionsBydivisionId(divisionId);
	}
}

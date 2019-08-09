package com.hirak.api.repository;

import java.util.List;

import com.hirak.api.entity.Division;
import com.hirak.api.entity.Subdivision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivisionRepository extends CrudRepository<Subdivision, Integer> {
    public List<Subdivision> findAll();
    public List<Subdivision> findByDivision(Division division);
}

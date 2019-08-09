package com.hirak.api.repository;

import java.util.List;

import com.hirak.api.entity.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {
    public List<Division> findAll();

    public Division findById(int id);
}

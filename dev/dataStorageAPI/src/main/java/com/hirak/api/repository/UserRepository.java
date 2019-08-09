package com.hirak.api.repository;

import java.util.List;
import com.hirak.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findAll();
}

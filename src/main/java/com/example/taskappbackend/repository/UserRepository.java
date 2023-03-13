package com.example.taskappbackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.taskappbackend.entity.User;
public interface UserRepository extends CrudRepository<User, String> {

}

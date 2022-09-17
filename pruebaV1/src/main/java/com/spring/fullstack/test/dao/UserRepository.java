package com.spring.fullstack.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fullstack.test.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

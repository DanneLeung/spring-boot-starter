package com.xcesys.extras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcesys.extras.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.xcesys.extras.domain;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class UserRepository extends SimpleJpaRepository<User,Long>{

	public UserRepository(Class<User> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
	
}

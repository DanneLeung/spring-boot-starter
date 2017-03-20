package com.xcesys.extras.framework.entity;

// Generated 2012-5-24 10:43:56 by Hibernate Tools 3.4.0.CR1

import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.xcesys.extras.framework.dao.model.IdTreeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 */
//@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Organization extends IdTreeEntity<Organization> {

	private static final long serialVersionUID = -2721701188883118359L;
	private String no;
	private Boolean enabled;
	private String name;
	private Set<User> users;
	private User owner;

}

package com.xcesys.extras.framework.entity;

// Generated 2010-11-25 14:39:17 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.xcesys.extras.framework.core.model.IdTreeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Module generated by hbm2java
 */
// @Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Module extends IdTreeEntity<Module> implements java.io.Serializable {

	private static final long serialVersionUID = 7838223715656256416L;
	private String description;
	private Boolean editable = Boolean.TRUE;
	private String entry;
	private Set<Permission> permissions = new HashSet<Permission>(0);
	private Subsystem subsystem;

}

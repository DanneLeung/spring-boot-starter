package com.xcesys.extras.framework.entity;

// Generated 2010-11-25 11:58:51 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Subsystem generated by hbm2java
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Subsystem extends IdAuditableEntity {
	private static final long serialVersionUID = -3626472224730691910L;
	@Column(unique = true)
	@NonNull
	private String name;
	private String description;
	private Boolean enabled;
	// private Set<Module> modules = new HashSet<Module>(0);
	@OneToMany(mappedBy = "subsystem")
	private Set<Permission> permissions = new HashSet<Permission>(0);
}

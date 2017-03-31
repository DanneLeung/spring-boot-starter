package com.xcesys.extras.framework.entity;

// Generated 2010-11-25 11:58:51 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Permission extends IdAuditableEntity implements java.io.Serializable {

	private static final long serialVersionUID = 3376006942984531464L;
	private String aclPattern;
	private String actionName;
	// private Set<Permission> dependsPermissions = new HashSet<Permission>(0);
	private String description;
	private String name;
	// private Permission requirePermission;
	// private Set<Menu> tsMenus = new HashSet<Menu>(0);
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn
	// private Module module;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_permissions", joinColumns = {
			@JoinColumn(name = "permissions_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "roles_id", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>(0);
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Subsystem subsystem;
	protected String displayName;

	// @Transient
	// public String getDisplayName() {
	// if (!StringUtils.isBlank(this.displayName)) {
	// return this.displayName;
	// }
	// if (this.module != null) {
	// this.displayName = this.module.getTreeName() + ">" + this.name;
	// } else {
	// this.displayName = this.name;
	// }
	// return displayName;
	// }

}

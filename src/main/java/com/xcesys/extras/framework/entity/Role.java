package com.xcesys.extras.framework.entity;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.dao.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Role extends IdAuditableEntity {
	private static final long serialVersionUID = 4371762231795963170L;
	@JsonView(DataTablesOutput.View.class)
	private String description;
	@Column(unique = true)
	@NonNull
	@JsonView(DataTablesOutput.View.class)
	private String name;
	@JsonView(DataTablesOutput.View.class)
	private boolean editable = true;
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();
	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "roles_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "users_id", nullable = false, updatable = false) })
	private Set<User> users = new HashSet<User>();

	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "role_permissions", joinColumns = {
			@JoinColumn(name = "roles_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "permissions_id", nullable = false, updatable = false) })
	private Set<Permission> permissions = new HashSet<Permission>(0);

}

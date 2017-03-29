package com.xcesys.extras.framework.entity;

import static javax.persistence.FetchType.EAGER;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IEditable;
import com.xcesys.extras.framework.core.model.IdAuditableEntity;

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
@Getter
@Setter
public class User extends IdAuditableEntity implements UserDetails, IEditable {
	private static final long serialVersionUID = -6943871074854331138L;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean accountNonExpired = true;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean accountNonLocked = true;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean admin = false;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean credentialsNonExpired = true;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean editable = true;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String email;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean enabled = true;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String fullname;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String mobile;
	private String password;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToMany(fetch = EAGER)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "users_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "roles_id", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>();
	@Column(unique = true)
	@NonNull
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String username;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<>();
		for (Role role : getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedAuthorities;
	}
}

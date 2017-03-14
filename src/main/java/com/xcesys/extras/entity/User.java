package com.xcesys.extras.entity;

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.entity.IdEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User extends IdEntity implements UserDetails, Serializable {
	private static final long serialVersionUID = -6943871074854331138L;
	@JsonView(DataTablesOutput.View.class)
	private boolean accountNonExpired;
	@JsonView(DataTablesOutput.View.class)
	private boolean accountNonLocked;
	@JsonView(DataTablesOutput.View.class)
	private boolean credentialsNonExpired;
	@JsonView(DataTablesOutput.View.class)
	private String dateFormat = "yyyy/MM/dd";
	@JsonView(DataTablesOutput.View.class)
	private String email;
	@JsonView(DataTablesOutput.View.class)
	private boolean enabled;
	@JsonView(DataTablesOutput.View.class)
	private String fullname;
	@JsonView(DataTablesOutput.View.class)
	private Locale locale;
	@NonNull
	@JsonView(DataTablesOutput.View.class)
	private String password;
	@JsonView(DataTablesOutput.View.class)
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();
	@JsonView(DataTablesOutput.View.class)
	@ManyToMany(mappedBy = "users", fetch = EAGER)
	private Set<Role> roles = new HashSet<Role>();
	@JsonView(DataTablesOutput.View.class)
	private String timeFormat = "HH.mm";
	@Column(unique = true)
	@NonNull
	@JsonView(DataTablesOutput.View.class)
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

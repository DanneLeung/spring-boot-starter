package com.xcesys.extras.entity;

import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PROTECTED;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xcesys.extras.entity.abstracts.IdEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Getter
@Setter
public class User extends IdEntity implements UserDetails, Serializable {

	@Column(unique = true)
	@NonNull
	private String username;
	@NonNull
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Date automaticLogoutTime;
	private Locale locale;
	private String dateFormat = "yyyy/MM/dd";
	private String timeFormat = "HH.mm";
	@ManyToMany(mappedBy = "users", fetch = EAGER)
	private Set<Role> roles = new HashSet();
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<>();
		for (Role role : getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedAuthorities;
	}
}

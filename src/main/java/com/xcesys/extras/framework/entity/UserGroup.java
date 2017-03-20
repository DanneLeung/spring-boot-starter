package com.xcesys.extras.framework.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class UserGroup extends IdAuditableEntity implements Serializable {

	private static final long serialVersionUID = -2969876357784297539L;
	@Column(unique = true)
	@NonNull
	private String name;
	@ElementCollection(targetClass = Role.class, fetch = EAGER)
	@Enumerated(STRING)
	private Set<Role> roles = new HashSet<Role>();
	@ManyToMany(cascade = ALL, fetch = LAZY)
	private Set<User> users = new HashSet<User>();
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();
}

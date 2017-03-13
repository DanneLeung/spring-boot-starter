package com.xcesys.extras.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.xcesys.extras.entity.abstracts.IdEntity;

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
public class Role extends IdEntity implements Serializable {

	@Column(unique = true)
	@NonNull
	private String name;
	private String description;
	@ManyToMany(cascade = ALL, fetch = LAZY)
	private Set<User> users = new HashSet();
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet();
}

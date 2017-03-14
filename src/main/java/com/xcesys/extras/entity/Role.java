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

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
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
	private static final long serialVersionUID = 4371762231795963170L;
	@Column(unique = true)
	@NonNull
	@JsonView(DataTablesOutput.View.class)
	private String name;
	@JsonView(DataTablesOutput.View.class)
	private String description;
	@ManyToMany(cascade = ALL, fetch = LAZY)
	private Set<User> users = new HashSet<User>();
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();
}

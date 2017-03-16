package com.xcesys.extras.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

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
@Setter
@Getter
public class Role extends IdEntity implements Serializable {
	private static final long serialVersionUID = 4371762231795963170L;
	@JsonView(DataTablesOutput.View.class)
	private String description;
	@Column(unique = true)
	@NonNull
	@JsonView(DataTablesOutput.View.class)
	private String name;
	@OneToMany(fetch = EAGER)
	private Set<PreferenceValue> preferenceValues = new HashSet<PreferenceValue>();
	@ManyToMany(cascade = ALL, fetch = LAZY)
	private Set<User> users = new HashSet<User>();
}

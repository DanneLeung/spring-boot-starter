package com.xcesys.extras.framework.entity;

// Generated 2012-5-24 10:43:56 by Hibernate Tools 3.4.0.CR1

import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IdTreeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Organization extends IdTreeEntity<Organization> {

	private static final long serialVersionUID = -2721701188883118359L;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String no;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Boolean enabled;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Set<User> users;
	
	private User owner;

}

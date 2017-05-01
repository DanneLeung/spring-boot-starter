package com.saic.epa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
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
@Table(name="TM_BAS_VHC")
public class Vehicle extends IdAuditableEntity {

	private static final long serialVersionUID = 2194461950484681352L;
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Override
	@Column(name = "TM_AREA_ID")
	public Long getId() {
		return super.getId();
	}

	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 说明
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String description;
}

package com.xcesys.extras.epa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

/**
 * 车型数据模型
 * @author danne
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TM_BAS_VHC")
public class Vehicle extends IdAuditableEntity {

	private static final long serialVersionUID = 2194461950484681352L;

	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;

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

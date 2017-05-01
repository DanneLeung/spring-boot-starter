package com.saic.epa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * 标签
 * 
 * @author danne
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TM_TAG")
public class Tag extends IdAuditableEntity {
	private static final long serialVersionUID = 9067340437829608488L;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Override
	@Column(name = "TM_TAG_ID")
	public Long getId() {
		return super.getId();
	}

	/**
	 * 数据类型
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String type;
	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 默认值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "DEF_VALUE")
	private String defaultValue;

	/**
	 * 单位
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String unit;

	/**
	 * 枚举值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String valueCode;
	/**
	 * 检验算式
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String calculate;
	/**
	 * 检验标准值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String standard;
	/**
	 * 允许空值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String isnull;
	/**
	 * 是否入库
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Boolean storage;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "databar_tags", joinColumns = {
			@JoinColumn(name = "tag_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "databar_id", nullable = false, updatable = false) })
	private DataBar databar;
}

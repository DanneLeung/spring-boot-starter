package com.xcesys.extras.epa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Cacheable
@Table(name = "TR_DATA_BAR_TAG")
public class AreaDatabarTag extends IdAuditableEntity {
	private static final long serialVersionUID = 9067340437829608488L;
	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TR_DATA_BAR_TAG_ID")
	private Long id;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_AREA_ID")
	private Long area;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TT_DATA_BAR_ID")
	private Long databar;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "ORDERS")
	private Integer orders;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TT_TAG_ID")
	private Tag tag;
}

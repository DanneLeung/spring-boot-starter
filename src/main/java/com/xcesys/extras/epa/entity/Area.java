package com.xcesys.extras.epa.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
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
@Table(name = "TM_AREA")
public class Area extends IdAuditableEntity {
	private static final long serialVersionUID = -3356325683038483403L;

	/**
	 * 功能分类 1点检 2工艺 3质量
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private int type;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String picture;

	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;

	// @JsonIgnore
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "TR_AREA_DATA_BAR", joinColumns = {
			@JoinColumn(name = "TM_AREA_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TM_DATA_BAR_ID", nullable = false, updatable = false) })
	@OrderColumn(name = "orders")
	private Set<DataBar> databars = new LinkedHashSet<DataBar>(0);

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_AREA_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_AREA_ID")
	private Long id;
}

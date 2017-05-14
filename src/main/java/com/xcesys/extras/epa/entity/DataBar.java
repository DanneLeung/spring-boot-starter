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
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TM_DATA_BAR")
public class DataBar extends IdAuditableEntity {

	private static final long serialVersionUID = -5012274748925500133L;

	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_DATA_BAR_ID")
	private Long id;
	/**
	 * 区域
	 */
	@JsonIgnore
	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "TR_AREA_DATA_BAR", joinColumns = {
			@JoinColumn(name = "TM_DATA_BAR_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TM_AREA_ID", nullable = false, updatable = false) })
	private Set<Area> areas;
	/**
	 * 功能分类
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String type;
	/**
	 * 描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 图片路径
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String picture;

	// @JsonIgnore
	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "TR_DATA_BAR_TAG", joinColumns = {
			@JoinColumn(name = "TT_DATA_BAR_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TT_TAG_ID", nullable = false, updatable = false) })
	// @OrderBy("orders")
	private Set<Tag> tags = new LinkedHashSet<Tag>();
}

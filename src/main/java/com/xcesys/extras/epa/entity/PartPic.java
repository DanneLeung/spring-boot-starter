package com.xcesys.extras.epa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/**
 * 图形部件
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
@Table(name = "TM_BAS_PARTS_PIC")
public class PartPic extends IdAuditableEntity {

	private static final long serialVersionUID = -5658966165742176791L;
	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_BAS_VHC_ID", insertable = false, updatable = false)
	private Vehicle vehicle;

	@Column(name = "TM_BAS_VHC_ID")
	private Long vehicleId;
	/**
	 * 
	 */
	@JsonIgnore
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne
	private PartPic parent;
	/**
	 * 部件名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PARTS_NAME")
	private String partName;
	/**
	 * 部件描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PARTS_DESC")
	private String partDesc;
	/**
	 * 缩略图
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_THN")
	private String thumb;
	/**
	 * 完整图
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_CMP")
	private String picture;

	/**
	 * 排序
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "SORT")
	private int sort;

	/**
	 * 逻辑删除
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "MARK_FOR_DEL")
	private Boolean deleted;

}

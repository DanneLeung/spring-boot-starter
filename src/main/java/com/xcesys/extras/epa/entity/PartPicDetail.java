package com.xcesys.extras.epa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
 * 图形部件明细
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
@Table(name = "TM_BAS_PARTS_PIC_DTL")
public class PartPicDetail extends IdAuditableEntity {

	private static final long serialVersionUID = -5658966165742176791L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_BAS_PARTS_PIC_DTL_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_BAS_PARTS_PIC_ID", insertable = false, updatable = false)
	private PartPic partPic;

	@Column(name = "TM_BAS_PARTS_PIC_ID")
	private Long partPicId;
	/**
	 * 图形名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_NAME")
	private String name;
	/**
	 * 图形描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_DESC")
	private String desc;
	/**
	 * 方位(1:正面;0:反面)
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "AZIMUCH")
	private int azimuch;
	/**
	 * 存储路径
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_PATH")
	private String path;

	/**
	 * 部位分区
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "PIC_POSITION")
	private String position;

	/**
	 * 是否标记为删除
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "MARK_FOR_DEL")
	private Boolean deleted;

}

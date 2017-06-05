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
 * 质量过程数据
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
@Table(name = "TT_QUALITY_DATA_PROCESS")
public class QualityData extends IdAuditableEntity {

	private static final long serialVersionUID = 8319422858003215190L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TT_QUALITY_DATA_PROCESS_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TT_QUALITY_DATA_PROCESS_ID")
	private Long id;

	/**
	 * 区域
	 */
	// @JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "TM_AREA_ID")
	// private Area area;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_DATA_BAR_ID", insertable = false, updatable = false)
	private DataBar databar;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_DATA_BAR_ID")
	private Long databarId;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_TAG_ID", insertable = false, updatable = false)
	private Tag tag;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_TAG_ID")
	private Long tagId;

	/**
	 * 批次ID
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TT_BATCH_ID")
	private String batchId;
	/**
	 * 值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String dataValue;
	/**
	 * 是否报警
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "ISWARN")
	private Boolean iswarn;
}

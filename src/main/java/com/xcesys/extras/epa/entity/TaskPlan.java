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
 * 任务规则
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
@Table(name = "TM_PLAN_HEADER")
public class TaskPlan extends IdAuditableEntity {
	private static final long serialVersionUID = 3893664023484789028L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_PLAN_HEADER_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_PLAN_HEADER_ID")
	private Long id;

	/**
	 * 区域
	 */
	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_AREA_ID", insertable = false, updatable = false)
	private Area area;

	@Column(name = "TM_AREA_ID")
	private Long areaId;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_DATA_BAR_ID", insertable = false, updatable = false)
	private DataBar databar;

	@Column(name = "TM_DATA_BAR_ID")
	private Long databarId;

	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 周期
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String cycle;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String work;

	/**
	 * 领取开始时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String receiveStartTime;
	/**
	 * 领取截止时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String receiveEndTime;
	/**
	 * 上传截止时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String uploadEndTime;
	/**
	 * 负责人
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long worker;

}

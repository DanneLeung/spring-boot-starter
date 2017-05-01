package com.xcesys.extras.epa.entity;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 任务矩阵
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
@Table(name = "TT_TASK")
public class Task extends IdAuditableEntity {
	private static final long serialVersionUID = 9067340437829608488L;
	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TT_TASK_ID")
	private Long id;
	/**
	 * 区域
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_AREA_ID")
	private Area area;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_DATA_BAR_ID")
	private DataBar databar;

	/**
	 * 任务状态
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TASK_STATUS")
	private String status;
	/**
	 * 工作日
	 */
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

	/**
	 * 任务分派时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date allocateTime;
	/**
	 * 任务提取时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date receiveTime;
	/**
	 * 任务操作时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date workTime;
	/**
	 * 任务提交时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date commitTime;
	/**
	 * 设备
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String device;
}

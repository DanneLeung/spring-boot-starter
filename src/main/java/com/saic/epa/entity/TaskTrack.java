package com.saic.epa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
 * 任务跟踪数据
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
public class TaskTrack extends IdAuditableEntity {

	private static final long serialVersionUID = 2508992068890090260L;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private TaskDataProcess process;
	/**
	 * 任务状态
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String status;
	/**
	 * 上传截止时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date uploadEndTime;

	/**
	 * 负责人
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private int worker;
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
	private String remark;
}

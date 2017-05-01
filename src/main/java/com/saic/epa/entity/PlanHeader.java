package com.saic.epa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TM_PLAN_HEADER")
public class PlanHeader extends IdAuditableEntity {
	private static final long serialVersionUID = 3893664023484789028L;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Override
	@Column(name = "TM_PLAN_HEADER_ID")
	public Long getId() {
		return super.getId();
	}

	/**
	 * 区域
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Area area;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private DataBar databar;
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
	private Date receiveStartTime;
	/**
	 * 领取截止时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date receiveEndTime;
	/**
	 * 上传截止时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date uploadEndTime;
	/**
	 * 负责人
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long worker;

}

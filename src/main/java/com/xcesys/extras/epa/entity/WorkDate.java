package com.xcesys.extras.epa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

/**
 * 工作日例外
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
@Table(name = "TM_WORK_DATE")
public class WorkDate extends IdAuditableEntity {
	private static final long serialVersionUID = -805246265360988602L;
	
	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_WORK_DATE_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_WORK_DATE_ID")
	private Long id;

	/**
	 * 0:放假 1：上班
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private int type;

	/**
	 * 工作日
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Date workDate;
}

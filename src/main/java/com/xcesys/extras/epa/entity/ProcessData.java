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
 * 工艺过程数据
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
@Table(name = "TT_DATA_PROCESS")
public class ProcessData extends IdAuditableEntity {

	private static final long serialVersionUID = -5012274748925500133L;

	@Id
	@GeneratedValue
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TT_DATA_PROCESS_ID")
	private Long id;

	@JsonIgnore
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_DATA_BAR_ID")
	private DataBar databar;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TM_TAG_ID")
	private Tag tag;

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
	private boolean iswarn;
}

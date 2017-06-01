package com.xcesys.extras.epa.entity;

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
 * App发行包版本
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
@Table(name = "TM_BASE_DATA_VERSION")
public class DataVersion extends IdAuditableEntity {
	private static final long serialVersionUID = -3356325683038483403L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_BASE_DATA_VERSION_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;
	/**
	 * 版本号
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private long version;

	/**
	 * 数据类型（apk、）
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String type;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String fileName;

	/**
	 * 存储路径
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String filePath;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String remark;
}

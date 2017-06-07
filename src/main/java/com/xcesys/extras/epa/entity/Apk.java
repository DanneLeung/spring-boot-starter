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
 * APP用户Token记录
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
@Table(name = "TM_BAS_APK")
public class Apk extends IdAuditableEntity {

	private static final long serialVersionUID = -7533861019747009252L;
	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_BAS_APK_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;
	/**
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String type;
	/**
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String version;
	/**
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String fileName;
	/**
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String filePath;
	/**
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String remark;
 

}

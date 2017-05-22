package com.xcesys.extras.epa.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
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
import com.xcesys.extras.epa.entity.converter.BooleanConverter;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 字典数据
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
@Table(name = "TS_DICTIONARY")
public class Dict extends IdAuditableEntity {

	private static final long serialVersionUID = -4000888529682067654L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TS_DICTIONARY_ID")	
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;

	@JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DICTIONARY_TYPE_ID", insertable = false, updatable = false)
	private DictType type;

	@Column(name = "DICTIONARY_TYPE_ID")
	private Long typeId;

	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "DICT_NAME")
	private String name;
	/**
	 * 描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String more;
	/**
	 * 键
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "DICT_KEY")
	private String key;

	/**
	 * 值
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "DICT_VALUE")
	private String value;

	/**
	 * 激活
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(columnDefinition = "CHAR(1)")
	@Convert(converter = BooleanConverter.class, attributeName = "enabled")
	private Boolean enabled;
	/**
	 * 可編輯
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(columnDefinition = "CHAR(1)")
	@Convert(converter = BooleanConverter.class, attributeName = "editable")
	private Boolean editable;

}

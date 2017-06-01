package com.xcesys.extras.epa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 * 字典类型
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
@Table(name = "TS_DICTIONARY_TYPE")
public class DictType extends IdAuditableEntity {

	private static final long serialVersionUID = -5005640655497740651L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TS_DICTIONARY_TYPE_ID")	
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;

	// @JsonIgnore
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	// @ManyToOne
	// @JoinColumn(name="parent_id")
	// private DictType parent;
	/**
	 * 键
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String code;
	/**
	 * 名称
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String more;

	@OneToMany(mappedBy="type")
	private Set<Dict> dicts = new HashSet<Dict>(0);

}

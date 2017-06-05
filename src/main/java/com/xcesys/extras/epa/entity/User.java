package com.xcesys.extras.epa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.epa.entity.converter.BooleanConverter;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Table(name = "TS_USER")
public class User extends IdAuditableEntity {
	private static final long serialVersionUID = -3356325683038483403L;
	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TS_USER_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;
	/**
	 * 登录帐号
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "ACCOUNT")
	private String username;
	/**
	 * 用户名
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;

	/**
	 * 用户密码
	 */
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String password;
	/**
	 * 是否域用户(1:是)
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(columnDefinition = "CHAR(1)")
	@Convert(converter = BooleanConverter.class, attributeName = "deleted")
	private Boolean ldapUser;
	/**
	 * 邮箱
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String email;
	/**
	 * 删除标识
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(columnDefinition = "CHAR(1)")
	@Convert(converter = BooleanConverter.class, attributeName = "deleted")
	private Boolean deleted = false;
}

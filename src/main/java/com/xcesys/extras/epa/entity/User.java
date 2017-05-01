package com.xcesys.extras.epa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TS_USER")
public class User extends IdAuditableEntity {
	private static final long serialVersionUID = -3356325683038483403L;
	@Id
	@GeneratedValue
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
//	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String password;
	/**
	 * 是否域用户(1:是)
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String ldapUser;
	/**
	 * 邮箱
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String email;
	/**
	 * 删除标识
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String deleted;
}

package com.xcesys.extras.epa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "TT_APP_TOKEN")
public class AppToken extends IdAuditableEntity {
	public static final int TIMEOUT = 3600 * 24;
	private static final long serialVersionUID = -1544123097056081249L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TT_APP_TOKEN_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Long id;
	/**
	 * 用户
	 */
	@NonNull
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * 最新TOKEN码
	 */
	@NonNull
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String token;

	/**
	 * 最后登录时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "LAST_LOGON_TIME")
	private Date lastLogonTime;

	/**
	 * 过期时间
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TIMEOUT")
	private Date timeout;

}

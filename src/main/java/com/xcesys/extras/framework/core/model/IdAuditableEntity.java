package com.xcesys.extras.framework.core.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.LazyInitializationException;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.framework.core.bean.PageResult;

import lombok.Getter;
import lombok.Setter;

@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class IdAuditableEntity extends IdEntity {

	private static final long serialVersionUID = 4289767748946880713L;

	@ManyToOne
	@CreatedBy
	@JoinColumn(name = "CREATE_USER_ID")
	private User createdBy;

	@Column(name = "CREATE_USER_NAME")
	private String createdByUsername;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createdDate;

	@ManyToOne
	@LastModifiedBy
	@JoinColumn(name = "UPDATE_USER_ID")
	private User updatedBy;

	@Column(name = "UPDATE_USER_NAME")
	private String updatedByUsername;

	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	private Date updatedDate;

	public void setCreatedBy(User user) {
		this.createdBy = user;
		if (user != null) {
			this.createdByUsername = user.getUsername();
		}
	}

	public void setUpdateBy(User user) {
		this.updatedBy = user;
		if (user != null) {
			this.updatedByUsername = user.getUsername();
		}
	}

	@Override
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
		} catch (LazyInitializationException e) {
			return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("id", getId()).toString();
		}
	}
}

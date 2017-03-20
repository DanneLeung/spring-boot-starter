package com.xcesys.extras.framework.core.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
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

	@CreatedBy
	private String createdBy;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(DataTablesOutput.View.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(DataTablesOutput.View.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	//
	// public String getCreatedBy() {
	// return createdBy;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.springframework.data.domain.Auditable#getCreatedDate()
	// */
	// public DateTime getCreatedDate() {
	//
	// return null == createdDate ? null : new DateTime(createdDate);
	// }
	//
	// public String getLastModifiedBy() {
	// return lastModifiedBy;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
	// */
	// public DateTime getLastModifiedDate() {
	//
	// return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
	// }
	//
	// public void setCreatedBy(String createdBy) {
	// this.createdBy = createdBy;
	// }
	//
	// public void setCreatedDate(Date createdDate) {
	// this.createdDate = createdDate;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// * org.springframework.data.domain.Auditable#setCreatedDate(org.joda.time
	// * .DateTime)
	// */
	// public void setCreatedDate(final DateTime createdDate) {
	//
	// this.createdDate = null == createdDate ? null : createdDate.toDate();
	// }
	//
	// public void setLastModifiedBy(String lastModifiedBy) {
	// this.lastModifiedBy = lastModifiedBy;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// * org.springframework.data.domain.Auditable#setLastModifiedDate(org.joda
	// * .time.DateTime)
	// */
	// public void setLastModifiedDate(final DateTime lastModifiedDate) {
	//
	// this.lastModifiedDate = null == lastModifiedDate ? null :
	// lastModifiedDate.toDate();
	// }

	@Override
	public String toString() {
		try {
			return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
		} catch (LazyInitializationException e) {
			return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("id", getId()).toString();
		}
	}
}

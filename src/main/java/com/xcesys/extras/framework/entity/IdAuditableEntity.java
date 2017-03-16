package com.xcesys.extras.framework.entity;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.LazyInitializationException;
import org.joda.time.DateTime;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.entity.User;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class IdAuditableEntity extends AbstractAuditable<User, Long> {

	private static final long serialVersionUID = 4289767748946880713L;

	@JsonView(DataTablesOutput.View.class)
	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	@JsonView(DataTablesOutput.View.class)
	public User getCreatedBy() {
		return super.getCreatedBy();
	}

	@Override
	@JsonView(DataTablesOutput.View.class)
	public DateTime getCreatedDate() {
		return super.getCreatedDate();
	}

	@Override
	@JsonView(DataTablesOutput.View.class)
	public User getLastModifiedBy() {
		return super.getLastModifiedBy();
	}

	@Override
	@JsonView(DataTablesOutput.View.class)
	public DateTime getLastModifiedDate() {
		return super.getLastModifiedDate();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Override
	public String toString() {
		try {
			return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
		} catch (LazyInitializationException e) {
			return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("id", getId()).toString();
		}
	}
}

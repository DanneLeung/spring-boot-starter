package com.xcesys.extras.entity.abstracts;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.LazyInitializationException;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public class IdEntity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -3632024614761342356L;

	@JsonView(DataTablesOutput.View.class)
	@Override
	public Long getId() {
		return super.getId();
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

package com.xcesys.extras.framework.core.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.LazyInitializationException;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicInsert
@DynamicUpdate
@MappedSuperclass
public class IdEntity extends AbstractEntity<Long> {

	private static final long serialVersionUID = -3632024614761342356L;

	// @Id
	// @GeneratedValue
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })

	@Override
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
		} catch (LazyInitializationException e) {
			return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("id", getId()).toString();
		}
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
		
	}
}

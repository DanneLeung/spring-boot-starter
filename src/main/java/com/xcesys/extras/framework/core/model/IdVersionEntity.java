package com.xcesys.extras.framework.core.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.LazyInitializationException;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class IdVersionEntity extends AbstractPersistable<Long> {

	@Version
	@Setter(AccessLevel.PROTECTED)
	private Long version;

	@Override
	public String toString() {
		try {
			return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
		} catch (LazyInitializationException e) {
			return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("id", getId()).append("version", getVersion())
					.toString();
		}
	}
}

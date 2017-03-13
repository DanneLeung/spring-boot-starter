package com.xcesys.extras.entity.abstracts;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import static org.apache.commons.lang3.builder.ToStringStyle.*;
import org.hibernate.LazyInitializationException;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.xcesys.extras.entity.User;

@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class IdVersionAuditableEntity extends AbstractAuditable<User, Long> {

    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;

    @Override
    public String toString() {
        try {
            return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
        } catch (LazyInitializationException e) {
            return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                    .append("id", getId())
                    .append("version", getVersion())
                    .toString();
        }
    }
}

package com.xcesys.extras.framework.entity;

// Generated 2010-11-3 20:32:38 by Hibernate Tools 3.2.4.GA
import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
public class Sequence extends IdAuditableEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1688148021931497207L;
	private Boolean cycle;
	private String description;
	private Long initValue;
	private Long maxValue;
	private Long nextValue;
	private Boolean padding;
	private String paddingStr;
	private String prefix;
	private Date prevDate;
	private String resetBy;
	private Integer step;
	private String suffix;
	private String type;

}

package com.xcesys.extras.framework.entity;

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
public class Region extends IdAuditableEntity implements java.io.Serializable {

	private static final long serialVersionUID = 3373648995686911967L;
	/** 国家 */
	private String country;
	/** 编码 */
	private String code;
	/** 名称 */
	private String name;
	/***/
	private String description;
	/***/
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
	// private Set<StateCity> stateCities = new HashSet<StateCity>(0);

}

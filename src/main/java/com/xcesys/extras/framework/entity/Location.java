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
public class Location extends IdAuditableEntity implements java.io.Serializable {

	private static final long serialVersionUID = 2997026788130255715L;
	private String addressLine1;
	private String addressLine2;
	private String area;
	private String bizcircle;
	private String city;
	private String country = "CN";
	private String landMark;
	private String latitude;
	private String longitude;
	private String postCode;
	private String state;

}
